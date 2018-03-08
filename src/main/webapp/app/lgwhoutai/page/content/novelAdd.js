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
        ,data: arr
        ,response:{
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'count' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,cols: [[
             {field: 'username', title: '页数',}
            ,{field: 'city', width:'50%',title: '内容' }
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
        ]]
    });

});

var arr=[
    {
        "id": 10000,
        "username": "user-0",
        "sex": "女",
        "city": "城市-0",
        "sign": "签名-0",
        "experience": 255,
        "logins": 24,
        "wealth": 82830700,
        "classify": "作家",
        "score": 57
    },
    {
        "id": 10001,
        "username": "user-1",
        "sex": "男",
        "city": "城市-1",
        "sign": "签名-1",
        "experience": 884,
        "logins": 58,
        "wealth": 64928690,
        "classify": "词人",
        "score": 27
    },
    {
        "id": 10002,
        "username": "user-2",
        "sex": "女",
        "city": "城市-2",
        "sign": "签名-2",
        "experience": 650,
        "logins": 77,
        "wealth": 6298078,
        "classify": "酱油",
        "score": 31
    },
    {
        "id": 10003,
        "username": "user-3",
        "sex": "女",
        "city": "城市-3",
        "sign": "签名-3",
        "experience": 362,
        "logins": 157,
        "wealth": 37117017,
        "classify": "诗人",
        "score": 68
    }

];