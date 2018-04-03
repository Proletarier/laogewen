layui.use(['form','laydate','table','laypage','jquery','layer'], function(){
    var laydate=layui.laydate
        ,table = layui.table
        ,form=layui.form
        ,layer = parent.layer === undefined ? layui.layer : parent.layer
        ,laypage = layui.laypage
    $ = layui.jquery;

    table.render({
        skin: 'line' //行边框风格
        ,elem: '#movie'
        ,height: 500
        ,data: arr
        ,page: true
        ,response:{
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'count' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,cols: [[
            {type:'checkbox'}
            ,{field: 'username', width:'20%',title: '电影名称', }
            ,{field: 'city', title: '电影类型' }
            ,{field: 'sign', title: '文件地址'}
            ,{field: 'classify', title: '创建时间'}
            ,{field: 'wealth', title: '点击数量',  sort: true}
            ,{field:'sex', title:'是否展示',  templet: '#switchTpl', unresize: true}
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
        ]]
    });

    form.render();

    //日期范围
    laydate.render({
        elem: '#createDate'
        ,range: true
    });

    //添加电影
    $(window).one("resize",function(){
        $(".newsAdd_btn").click(function(){
            var index = layui.layer.open({
                title : "添加电影",
                type : 2,
                content : "movieAdd.html",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回电影列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        })
    }).resize();

});

