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
    },
    {
        "id": 10004,
        "username": "user-4",
        "sex": "男",
        "city": "城市-4",
        "sign": "签名-4",
        "experience": 807,
        "logins": 51,
        "wealth": 76263262,
        "classify": "作家",
        "score": 6
    },
    {
        "id": 10005,
        "username": "user-5",
        "sex": "女",
        "city": "城市-5",
        "sign": "签名-5",
        "experience": 173,
        "logins": 68,
        "wealth": 60344147,
        "classify": "作家",
        "score": 87
    },
    {
        "id": 10006,
        "username": "user-6",
        "sex": "女",
        "city": "城市-6",
        "sign": "签名-6",
        "experience": 982,
        "logins": 37,
        "wealth": 57768166,
        "classify": "作家",
        "score": 34
    },
    {
        "id": 10007,
        "username": "user-7",
        "sex": "男",
        "city": "城市-7",
        "sign": "签名-7",
        "experience": 727,
        "logins": 150,
        "wealth": 82030578,
        "classify": "作家",
        "score": 28
    },
    {
        "id": 10008,
        "username": "user-8",
        "sex": "男",
        "city": "城市-8",
        "sign": "签名-8",
        "experience": 951,
        "logins": 133,
        "wealth": 16503371,
        "classify": "词人",
        "score": 14
    },
    {
        "id": 10009,
        "username": "user-9",
        "sex": "女",
        "city": "城市-9",
        "sign": "签名-9",
        "experience": 484,
        "logins": 25,
        "wealth": 86801934,
        "classify": "词人",
        "score": 75
    }
];