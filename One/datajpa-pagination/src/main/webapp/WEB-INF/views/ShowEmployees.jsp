<%@taglib  uri="http://java.sun.com/jsp/jstl/core"       prefix="c"%>


<c:if   test="${!empty   employees}">
    <table  border="1">
        <tr>
            <th>EMPNO</th>
            <th>ENAME</th>
            <th>SAL</th>
            <th>DEPTNO</th>
        </tr>
        
        <c:forEach  items="${employees}"   var="e">
              <tr>
                   <td> <c:out  value="${e.empno }"/> </td>
                   <td> <c:out  value="${e.ename}"/> </td>
                   <td> <c:out  value="${e.sal }"/> </td>
                   <td> <c:out  value="${e.deptno }"/> </td>
              </tr>
        </c:forEach>
        
    </table>
    
   
    
    <c:if  test="${previous}">
        <a    href="getEmployees?pageIndex=${cpn-1}">  Prev</a>
     </c:if>
     
     &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
    
    <c:if  test="${next}">
        <a    href="getEmployees?pageIndex=${cpn+1}">  Next</a>
     </c:if>
  </c:if>
  
  