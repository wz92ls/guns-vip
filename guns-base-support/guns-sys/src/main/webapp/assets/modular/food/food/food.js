layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 食品表管理
     */
    var Food = {
        tableId: "foodTable"
    };

    /**
     * 初始化表格的列
     */
    Food.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'number', sort: true, title: '商品编号，UUID生成，唯一'},
            {field: 'name', sort: true, title: '商品名称'},
            {field: 'price', sort: true, title: '价格'},
            {field: 'productdate', sort: true, title: '生产日期'},
            {field: 'expirationdate', sort: true, title: '保质期  单位：天'},
            {field: 'stock', sort: true, title: '库存'},
            {field: 'unit', sort: true, title: '单位'},
            {field: 'status', sort: true, title: '状态：1.上架  2.下架'},
            {field: 'addtime', sort: true, title: '添加时间'},
            {field: 'updatetime', sort: true, title: '最后更新时间'},
            {field: 'addperson', sort: true, title: '添加人'},
            {field: 'description', sort: true, title: '描述'},
            {field: 'remark', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Food.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Food.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Food.openAddDlg = function () {
        func.open({
            title: '添加食品表',
            content: Feng.ctxPath + '/food/add',
            tableId: Food.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Food.openEditDlg = function (data) {
        func.open({
            title: '修改食品表',
            content: Feng.ctxPath + '/food/edit?id=' + data.id,
            tableId: Food.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Food.exportExcel = function () {
        var checkRows = table.checkStatus(Food.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Food.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/food/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Food.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Food.tableId,
        url: Feng.ctxPath + '/food/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Food.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Food.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Food.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Food.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Food.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Food.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Food.onDeleteItem(data);
        }
    });
});
