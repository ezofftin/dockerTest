<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="../include/header.jsp" %>

<div class="container w-75 mt-5 p-5 shadow">
    <h4>스프링 게시판</h4>
    <table class="table">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>조회수</th>
                <th>글쓴이</th>
                <th>등록/수정일</th>
                <th>좋아요</th>
            </tr>            
        </thead>
        <tbody>
            <c:forEach var="dto" items="${list}">
                <tr>
                    <td>${dto.bid}</td>
                    <td>
                        <a href="<c:url value='view.do?bid=${dto.bid}&viewPage=${pDto.viewPage}'/>">${dto.subject}</a>
                    </td>
                    <td>${dto.hit}</td>
                    <td>${dto.writer}</td>
                    <td><fmt:formatDate value="${dto.modify_date != null ? dto.modify_date : dto.reg_date}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <button class="btn btn-sm btn-outline-danger like-btn" data-bid="${dto.bid}">♥ ${dto.likes}</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" class="text-center">
                    <button class="btn btn-primary" id="btn-write">글쓰기</button>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- 페이지 네이션 -->
    <ul class="pagination justify-content-center">
        <li class="page-item ${pDto.prevPage <=0 ? 'disabled':''}">
            <a class="page-link" href="list.do?viewPage=${pDto.prevPage}">이전</a>
        </li>

        <c:forEach var="i" begin="${pDto.blockStart}" end="${pDto.blockEnd}">
            <li class="page-item ${pDto.viewPage == i ? 'active':''}">
                <a class="page-link" href="list.do?viewPage=${i}">${i}</a>
            </li>
        </c:forEach>

        <li class="page-item ${pDto.blockEnd >= pDto.totalPage ? 'disabled':''}">
            <a class="page-link" href="list.do?viewPage=${pDto.nextPage}">다음</a>
        </li>
    </ul>

    <script type="text/javascript">
        // 글쓰기 버튼 클릭 시 등록 페이지로 이동
        $("#btn-write").click(() => {
            location.href = "<c:url value='register.do'/>";
        });

        // 좋아요 버튼 클릭 이벤트
        $(".like-btn").click(function() {
            let bid = $(this).data("bid");
            let btn = $(this);

            $.ajax({
                type: "GET",
                url: "like.do",
                data: { bid: bid },
                success: function() {
                    let currentLikes = parseInt(btn.text().trim().replace("♥", ""));
                    btn.text("♥ " + (currentLikes + 1));
                },
                error: function() {
                    alert("좋아요 추가 실패!");
                }
            });
        });
    </script>

</div>
</body>
</html>
