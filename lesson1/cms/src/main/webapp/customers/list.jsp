<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.customers.size()} customer(s) in list.<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customers" items="${customers}">
        <tr>
            <td>
                <c:out value="${customers.id}"/>
            </td>
            <td>
                <a href="/customers/info.jsp?id=<c:out value="${customers.getId()}"/>"><c:out value="${customers.getName()}"/>
            </td>
            <td>
                <c:out value="${customers.getEmail()}"/>
            </td>
            <td>
                <c:out value="${customers.getAddress()}"/>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>