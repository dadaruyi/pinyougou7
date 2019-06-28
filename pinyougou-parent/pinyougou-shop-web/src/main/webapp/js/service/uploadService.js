//文件上传服务器
app.service("uploadService",function ($http) {
    this.uploadFile=function () {
        var formData=new FormData();
        formData.append("file",file.file[0]);
        return $http({
            method:'POST',
            url:"../upload.do",
            data:formData,
            header:{'Content-Type':undefined},
            transformRequest:angular.identity
        });
    }
});