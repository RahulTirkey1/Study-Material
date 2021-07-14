
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

<form:form  action="save"    method="post"  modelAttribute="pbean">
    product id : <form:input  path="productId"/> <br>
    product name: <form:input  path="productName"/> <br>
    price :  <form:input  path="price"/> <br>
    manufacturer: <form:input  path="manufacturer"/> <br>
    <input  type="submit"   value="submit">
</form:form>