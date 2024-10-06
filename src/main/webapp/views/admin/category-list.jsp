<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<table>
  <tr>
    <th>STT</th>
    <th>Images</th>
    <th>Category Name</th>
    <th>Status</th>
    <th>Action</th>
  </tr>

	<c:forEach items="${listcate}" var="cate" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
			<td><img height="150" width="200" src="${imgUrl}" /></td>
			<td>${cate.categoryname }</td>
			<td>${cate.status }</td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">Sửa</a>
				| <a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>">Xóa</a></td>
		</tr>
	</c:forEach>
</table>