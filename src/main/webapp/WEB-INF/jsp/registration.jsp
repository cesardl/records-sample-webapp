<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Hello World with Spring 4 MVC</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script type="text/javascript" src='<c:url value="/resources/registration.js"/>'></script>
    <script type="text/javascript">
        let projectUrl = '<c:url value="/"/>';
        if (projectUrl.indexOf(";", 0) != -1) {
            projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
        }

        function changeSelectValue(selectNode, value) {
            for (let index = 0; index < selectNode.length; index++) {
                if (selectNode[index].value === value)
                    selectNode.selectedIndex = index;
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container pt-4">
    <div>
        <h3>Registration Form</h3>
        <div class="mx-auto w-50">
            <form:form modelAttribute="record" action="/records/app/registration/add" name="recordForm">

                <form:hidden path="id"/>

                <spring:hasBindErrors name="record">
                    <c:forEach var="error" items="${errors.allErrors}">
                        <div class="alert alert-danger">
                            <spring:message message="${error}"/>
                        </div>
                    </c:forEach>
                </spring:hasBindErrors>

                <div class="form-group">
                    <label for="title">Title:</label>
                    <form:input path="title" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="releaseDate">Release Date:</label>
                    <form:input path="releaseDate" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="artistId">Artist Id:</label>
                    <form:input path="artistId" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="labelId">Label Id:</label>
                    <form:input path="labelId" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="created">Created:</label>
                    <form:input path="created" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="modified">Modified:</label>
                    <form:input path="modified" cssClass="form-control"/>
                </div>
                <div class="form-row">
                    <div class="col">
                        <input type="submit" class="btn btn-primary" value="Save Changes"/>
                    </div>
                    <div class="col">
                        <input type="reset" class="btn btn-info" name="newRecord" value="New Record"
                               onclick="setAddForm();"/>
                    </div>
                    <div class="col">
                        <input type="submit" class="btn btn-danger" name="deleteRecord" value="Delete Record"
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
                <tr class="thead-dark">
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
                        <td><c:out value="${record.releaseDate}"/></td>
                        <td><c:out value="${record.artistId}"/></td>
                        <td><c:out value="${record.labelId}"/></td>
                        <td><c:out value="${record.created}"/></td>
                        <td><c:out value="${record.modified}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
