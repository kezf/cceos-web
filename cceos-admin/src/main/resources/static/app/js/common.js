/**
 * 通用方法封装处理
 * Copyright (c) 2018 app
 */

$(function () {
    // select2复选框事件绑定
    if ($.fn.select2 !== undefined) {
        $("select.form-control:not(.noselect2)").each(function () {
            $(this).select2().on("change", function () {
                $(this).valid();
            })
        })
    }
    // checkbox 事件绑定
    if ($(".check-box").length > 0) {
        $(".check-box").iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
        })
    }
    // radio 事件绑定
    if ($(".radio-box").length > 0) {
        $(".radio-box").iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
        })
    }
    // laydate 时间控件绑定
    if ($(".select-time").length > 0) {
        layui.use('laydate', function () {
            var laydate = layui.laydate;
            var startDate = laydate.render({
                elem: '#startTime',
                max: $('#endTime').val(),
                theme: 'molv',
                trigger: 'click',
                done: function (value, date) {
                    // 结束时间大于开始时间
                    if (value !== '') {
                        endDate.config.min.year = date.year;
                        endDate.config.min.month = date.month - 1;
                        endDate.config.min.date = date.date;
                    } else {
                        endDate.config.min.year = '';
                        endDate.config.min.month = '';
                        endDate.config.min.date = '';
                    }
                }
            });
            var endDate = laydate.render({
                elem: '#endTime',
                min: $('#startTime').val(),
                theme: 'molv',
                trigger: 'click',
                done: function (value, date) {
                    // 开始时间小于结束时间
                    if (value !== '') {
                        startDate.config.max.year = date.year;
                        startDate.config.max.month = date.month - 1;
                        startDate.config.max.date = date.date;
                    } else {
                        startDate.config.max.year = '';
                        startDate.config.max.month = '';
                        startDate.config.max.date = '';
                    }
                }
            });
        });
    }
    // tree 关键字搜索绑定
    if ($("#keyword").length > 0) {
        $("#keyword").bind("focus", function focusKey(e) {
            if ($("#keyword").hasClass("empty")) {
                $("#keyword").removeClass("empty");
            }
        }).bind("blur", function blurKey(e) {
            if ($("#keyword").val() === "") {
                $("#keyword").addClass("empty");
            }
            $.tree.searchNode(e);
        }).bind("input propertychange", $.tree.searchNode);
    }
    // 复选框后按钮样式状态变更
    $("#bootstrap-table").on("check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table", function () {
        var ids = $("#bootstrap-table").bootstrapTable("getSelections");
        $('#toolbar .btn-del').toggleClass('disabled', !ids.length);
        $('#toolbar .btn-edit').toggleClass('disabled', ids.length != 1);
        ;
    });
    // tree表格树 展开/折叠
    var expandFlag = false;
    $("#expandAllBtn").click(function () {
        if (expandFlag) {
            $('#bootstrap-table').bootstrapTreeTable('expandAll');
        } else {
            $('#bootstrap-table').bootstrapTreeTable('collapseAll');
        }
        expandFlag = expandFlag ? false : true;
    })
});

/** 创建选项卡 */
function createMenuItem(dataUrl, menuName) {
    dataIndex = $.common.random(1, 100),
        flag = true;
    if (dataUrl == undefined || $.trim(dataUrl).length == 0) return false;
    var topWindow = $(window.parent.document);
    // 选项卡菜单已存在
    $('.menuTab', topWindow).each(function () {
        if ($(this).data('id') == dataUrl) {
            if (!$(this).hasClass('active')) {
                $(this).addClass('active').siblings('.menuTab').removeClass('active');
                $('.page-tabs-content').animate({marginLeft: ""}, "fast");
                // 显示tab对应的内容区
                $('.mainContent .app_iframe', topWindow).each(function () {
                    if ($(this).data('id') == dataUrl) {
                        $(this).show().siblings('.app_iframe').hide();
                        return false;
                    }
                });
            }
            flag = false;
            return false;
        }
    });
    // 选项卡菜单不存在
    if (flag) {
        var str = '<a href="javascript:;" class="active menuTab" data-id="' + dataUrl + '">' + menuName + ' <i class="fa fa-times-circle"></i></a>';
        $('.menuTab', topWindow).removeClass('active');

        // 添加选项卡对应的iframe
        var str1 = '<iframe class="app_iframe" name="iframe' + dataIndex + '" width="100%" height="100%" src="' + dataUrl + '" frameborder="0" data-id="' + dataUrl + '" seamless></iframe>';
        $('.mainContent', topWindow).find('iframe.app_iframe').hide().parents('.mainContent').append(str1);

        // 添加选项卡
        $('.menuTabs .page-tabs-content', topWindow).append(str);
    }
    return false;
}

/** 设置全局ajax超时处理 */
$.ajaxSetup({
    complete: function (XMLHttpRequest, textStatus) {
        if (textStatus == "parsererror") {
            $.modal.confirm("登陆超时！请重新登陆！", function () {
                window.location.href = ctx + "login";
            })
        }
    }
});

/*用户管理-部门*/
function dept() {
    var url = ctx + "system/dept";
    createMenuItem(url, "部门管理");
}

function queryDeptTree() {
    var url = ctx + "system/dept/treeData";
    var options = {
        url: url,
        expandLevel: 2,
        onClick: zOnClick
    };
    $.tree.init(options);

    function zOnClick(event, treeId, treeNode) {
        $("#deptId").val(treeNode.id);
        $("#parentId").val(treeNode.pId);
        $.table.search();
    }

    $('#btnExpand').click(function () {
        $._tree.expandAll(true);
        $(this).hide();
        $('#btnCollapse').show();
    });

    $('#btnCollapse').click(function () {
        $._tree.expandAll(false);
        $(this).hide();
        $('#btnExpand').show();
    });

    $('#btnRefresh').click(function () {
        queryDeptTree();
    });
}

/*用户管理-新增-选择部门树*/
function selectDeptTree() {
    var treeId = $("#treeId").val();
    var deptId = $.common.isEmpty(treeId) ? "100" : $("#treeId").val();
    var url = ctx + "system/dept/selectDeptTree/" + deptId;
    var options = {
        title: '选择部门',
        width: "380",
        url: url,
        callBack: doSubmit
    };
    $.modal.openOptions(options);
}

function doSubmit(index, layero) {
    var body = layer.getChildFrame('body', index);
    $("#treeId").val(body.find('#treeId').val());
    $("#treeName").val(body.find('#treeName').val());
    layer.close(index);
}
