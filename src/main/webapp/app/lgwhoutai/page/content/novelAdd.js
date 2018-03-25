layui.config({
    base : "js/"
}).use(['form','layer','jquery','layedit','laydate','table'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        table = layui.table;
        $ = layui.jquery;


    table.render({
        skin: 'line' //行边框风格
        ,elem: '#novelPage'
        ,height: 300
        ,width:700
        ,response:{
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'count' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,cols: [[
             {field: 'username', title: '页数',}
            ,{field: 'city', width:'40%',title: '内容' }
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
        ]]
    });

});