<%@taglib  uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

<table>
  <tr>
     <th> PRODUCTID</th>
     <th>PRODUCTNAME</th>
     <th>PRICE</th>
     <th>MANUFACTURER</th>
  </tr>
  <c:forEach   items="${products }"   var="p">
        <tr>
           <td> <c:out  value="${p.productId }"/> </td>
           <td> <c:out  value="${p.productName }"/> </td>
           <td> <c:out  value="${p.price }"/> </td>
           <td> <c:out  value="${p.manufacturer }"/> </td>
        </tr>   
  </c:forEach>
</table>