$(document).ready(function () {

        var cloneObj = $(".uploadDiv").clone();

        //업로드 버튼을 클릭했을 때
        $("#uploadBtn").on("click",function (e) {

            var regex = new RegExp("(.*?)/.(exe|sh|zip|alx)$");
            var maxSize = 5242880; //5MB

            function checkExtenstion(fileName, fileSize) {

                //파일 사이즈 체크 (현재 yml에서 체크 중)
                if (fileSize >= maxSize) {
                    alert("파일 사이즈 초과");
                    return false;
                }
                //파일 확장차 체크
                if (regex.test(fileName)) {
                    alert("해당 종류의 파일은 업로드할 수 없습니다.");
                    return false;
                }
                return true;
            }

            //Ajax를 이용하는 파일 업로드는 FormData를 이용해서 필요한 파라미터를 전송하는 방식이다.
            var formData = new FormData(); //가상의 Form태그
            var inputFile = $("input[name='uploadFile']"); //파일input에 들어오는 파일들

            var files = inputFile[0].files; //FormData 객체에 파일이 잘 추가 됐는지 확인하기 위해서 들어온 파일 전체를 찍어본다. 그럼 inputFile[1]은?
            console.log(files);

            //FormData 객체에 업로드한 전체 파일을 추가한다.
            for (var i = 0; i < files.length; i++) {

                if (!checkExtenstion(files[i].name, files[i].size)) {
                    return false;
                }
                formData.append("uploadFile",files[i]);
            }

            var uploadResult = $(".uploadResult ul");

            function showUploadedFile(uploadResultArr) {
                var str = "";

                $(uploadResultArr).each(function (i,obj) {

                    if (!obj.image) {
                        str += "<li><i class=\"fas fa-file-download\"></i>" + obj.fileName + "</li>";
                    }else {
                        //str += "<li>" + obj.fileName + "</li>";
                        var fileCallPath = encodeURIComponent("/s_" + obj.uuid + "_" + obj.fileName);
                        str += "<li><img src='/display?fileName="+fileCallPath+"'></li>";
                    }
                });

                uploadResult.append(str);
            }

            $.ajax({
                url: '/uploadAjaxAction',
                processData: false, //반드시 false
                contentType: false, //반드시 false
                data: formData, //Ajax를 통해서 formData 자체를 전송
                type: 'POST',
                dataType: 'json',
                success: function (result) {
                    console.log(result[0].uuid);
                    $(".uuid").val(result[0].uuid)
                    showUploadedFile(result);
                    $(".uploadDiv").html(cloneObj.html());
                }
            }) //$.ajax
        })
    })