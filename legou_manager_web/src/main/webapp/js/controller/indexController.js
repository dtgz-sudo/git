app.controller("indexController",function($scope,$http){
    // 显示用户的名称
    $scope.findLoginname = function(){
        // 发送get请求
        $http.get("../index/findLoginname").success(function(resp){
            if(resp.success){
                // 数	<script charset="utf-8" src="../plugins/kindeditor/lang/zh_CN.js"></script>据
                $scope.loginname = resp.data;
            }else{
                // 表示失败
                alert(resp.message);
            }
        });
    };

});