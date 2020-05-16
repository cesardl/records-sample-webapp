<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Hello World with Spring 4 MVC</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
          integrity="sha256-siyOpF/pBWUPgIcQi17TLBkjvNgNQArcmwJB8YvkAgg=" crossorigin="anonymous"/>

    <script type="text/javascript" src='<c:url value="/resources/registration.js"/>'></script>
    <script type="text/javascript">
        let projectUrl = '<c:url value="/"/>';
        if (projectUrl.indexOf(";", 0) !== -1) {
            projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
        }
    </script>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Registration Form</h2>
        </div>
        <div id="sandbox-container" class="panel-body">
            <form:form modelAttribute="record" action="/records/app/registration/add"
                       name="recordForm" cssClass="form-horizontal">

                <form:hidden path="id"/>

                <spring:hasBindErrors name="record">
                    <c:forEach var="error" items="${errors.allErrors}">
                        <div class="alert alert-danger">
                            <spring:message message="${error}"/>
                        </div>
                    </c:forEach>
                </spring:hasBindErrors>

                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title:</label>
                    <div class="col-sm-10">
                        <form:input path="title" cssClass="form-control input-sm"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="releaseDate" class="col-sm-2 control-label">Release Date:</label>
                    <div class="col-sm-10">
                        <div id="releaseDate-div" class="input-group date">
                            <form:input path="releaseDate" cssClass="form-control input-sm"/>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="artistId" class="col-sm-2 control-label">Artist Id:</label>
                    <div class="col-sm-10">
                        <form:input path="artistId" cssClass="form-control input-sm"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="labelId" class="col-sm-2 control-label">Label Id:</label>
                    <div class="col-sm-10">
                        <form:input path="labelId" cssClass="form-control input-sm"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="created" class="col-sm-2 control-label">Created:</label>
                    <div class="col-sm-10">
                        <div id="created-div" class="input-group date">
                            <form:input path="created" cssClass="form-control input-sm"/>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="modified" class="col-sm-2 control-label">Modified:</label>
                    <div class="col-sm-10">
                        <div id="modified-div" class="input-group date">
                            <form:input path="modified" cssClass="form-control input-sm"/>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4" style="text-align: center">
                        <input type="submit" class="btn btn-primary btn-sm" value="Save Changes"/>
                    </div>
                    <div class="col-md-4" style="text-align: center">
                        <input type="reset" class="btn btn-info btn-sm" name="newRecord" value="New Record"
                               onclick="setAddForm();"/>
                    </div>
                    <div class="col-md-4" style="text-align: center">
                        <input type="submit" class="btn btn-danger btn-sm" name="deleteRecord" value="Delete Record"
                               onclick="setDeleteForm();" disabled="disabled"/>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <div>
        <c:if test="${!empty records}">
            <br/>
            <table class='table table-striped table-hover'>
                <tr>
                    <th>Title</th>
                    <th>Release Date</th>
                    <th>Artist Id</th>
                    <th>Label Id</th>
                    <th>Created</th>
                    <th>Modified</th>
                </tr>
                <c:forEach items="${records}" var="record">
                    <tr id="${record.id}" onclick="setUpdateForm('${record.id}');">
                        <td><c:out value="${record.title}"/></td>
                        <td id="record-releaseDate-${record.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${record.releaseDate}"/></td>
                        <td><c:out value="${record.artistId}"/></td>
                        <td><c:out value="${record.labelId}"/></td>
                        <td id="record-created-${record.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${record.created}"/></td>
                        <td id="record-modified-${record.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${record.modified}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
        integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
        integrity="sha256-bqVeqGdJ7h/lYPq6xrPv/YGzMEb6dNxlfiTUHSgRCp8="
        crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#releaseDate-div,#created-div,#modified-div').datepicker({
            format: "dd/mm/yyyy",
            autoclose: true,
            todayHighlight: true
        });
    });
</script>
</body>
</html>
