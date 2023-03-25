
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:import url="header.jsp" />

<div class="content">
	
	<div class="details-product">
          <h2>${product.name}</h2>
          <div class="details-aria">

            <div class="colum-letf">
              <div class="details-img">
                <img style="height: 400px" src="${product.src}" alt="">
              </div>
              
            </div>
            <div class="right-colum">
              <table>
                <tr>
                  <td class="price">${product.price} $</td>
                </tr>
                <tr>
                  <td>Product Description:</td>
                </tr>
                <c:forEach var="des" items="${desAray}">
                 <tr>
                  <td style="padding-left:20px">${des}</td>
                </tr>
                </c:forEach>
               
              </table>
           	<div style="margin-top: 20px">
           	<a href="AddToCartController?id=${product.id}&action=add" class="btn-add">Add to cart</a>
           	</div>
              
            </div>
          </div>
          
        </div>

</div>

<c:import url="footer.jsp"></c:import>
