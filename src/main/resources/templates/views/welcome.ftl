<#assign base = request.contextPath />
<!DOCTYPE html>

<html lang="zh-CN">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="fyunli">

    <base id="base" href="${base}">
    <title>Spring Boot - hello</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/main.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="//cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Sprint Boot: Hello</h1>
    </div>

    <div>
        <h1>获取缓存数据如下</h1>
        Date: ${time?date}
        <br>
        Time: ${time?time}
        <br>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tbody>

            <#if (message?size > 0)>
                <#list message as being>
                <tr class="">
                    <td>缓存值
                    <td>
                    <td>${being}
                    <td>
                </tr>
                </#list>
            </#if>
            <#if (message?size = 0)>
            <h2>缓存数据为空</h2>
            </#if>


            </tbody>

        </table>
    </div>


</div>


<footer class="footer">
    <div class="container">
        <p class="text-muted">©2016 fyunli</p>
    </div>
</footer>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="//cdn.jsdelivr.net/ie10-viewport/1.0.0/ie10-viewport.min.js"></script>
<script src="//cdn.jsdelivr.net/jquery/1.12.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>