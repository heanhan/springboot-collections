<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>图片上传Demo</title>

    <style type="text/css">
        #divcss5{
            margin: 5px auto;
            width: 100px;
            height: 100px;
        }
        #divcss5 img{
            border-radius: 50%;
        }
    </style>
</head>
<body>
<h1>图片上传Demo</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data" >
    <p>选择文件: <input type="file" name="fileName"/></p>
    <p><input type="submit" value="提交"/></p>
</form>
<#--判断是否上传文件-->
<#if msg??>
    <span>${msg}</span><br>
<#else >
    <span>${msg!("文件未上传")}</span><br>
</#if>
<#--显示图片，一定要在img中的src发请求给controller，否则直接跳转是乱码-->
<#if fileName??>
    <div id="divcss5">
        <img src="/show?fileName=${fileName}" />
    </div>
<#else>
    <img src="/show" style="width: 200px"/>
</#if>
</body>
</html>