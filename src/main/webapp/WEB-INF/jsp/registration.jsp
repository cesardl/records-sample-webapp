<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Hello World with Spring 3 MVC</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <script type="text/javascript" src='<c:url value="/resources/common.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/registration.js"/>'></script>
    <script type="text/javascript">
        let projectUrl = '<c:url value="/"/>';
        if (projectUrl.indexOf(";", 0) != -1) {
            projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
        }
    </script>
</head>
<body>
<fieldset>
    <legend>Registration Form</legend>
    <center>
        <form:form modelAttribute="record" action="/records/app/registration/add" name="recordForm">

            <form:hidden path="id"/>
            <table>
                <tr>
                    <td colspan="2" align="left"><form:errors path="*" cssStyle="color : red;"/></td>
                </tr>
                <tr>
                    <td>Title :</td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td>Release Date :</td>
                    <td><form:input path="releaseDate"/></td>
                </tr>
                <tr>
                    <td>Artist Id :</td>
                    <td><form:input path="artistId"/></td>
                </tr>
                <tr>
                    <td>Label Id :</td>
                    <td><form:input path="labelId"/></td>
                </tr>
                <tr>
                    <td>Created :</td>
                    <td><form:input path="created"/></td>
                </tr>
                <tr>
                    <td>Modified :</td>
                    <td><form:input path="modified"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save Changes"/>
                        &nbsp;<input type="reset" name="newRecord" value="New Record" onclick="setAddForm();"
                                     disabled="disabled"/>
                        &nbsp;<input type="submit" name="deleteRecord" value="Delete Record" onclick="setDeleteForm();"
                                     disabled="disabled"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </center>
</fieldset>
<c:if test="${!empty records}">
    <br/>
    <center>
        <table width="90%">
            <tr style="background-color: gray;">
                <th>Title</th>
                <th>Release Date</th>
                <th>Artist Id</th>
                <th>Label Id</th>
                <th>Created</th>
                <th>Modified</th>
            </tr>
            <c:forEach items="${records}" var="record">
                <tr style="background-color: silver;" id="${record.id}" onclick="setUpdateForm('${record.id}');">
                    <td><c:out value="${record.title}"/></td>
                    <td><c:out value="${record.releaseDate}"/></td>
                    <td><c:out value="${record.artistId}"/></td>
                    <td><c:out value="${record.labelId}"/></td>
                    <td><c:out value="${record.created}"/></td>
                    <td><c:out value="${record.modified}"/></td>
                </tr>
            </c:forEach>
        </table>
    </center>
    <br/>

</c:if>
</body>
</html>
