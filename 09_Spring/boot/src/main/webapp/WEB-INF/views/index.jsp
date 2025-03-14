<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="init()">
    <jsp:include page="common/header.jsp" />
    <div class="content">
        <br><br>

        <div class="innerOuter">
            <h4>게시글 Top5</h4>
            <br>
                <table id="top5-board-list" class="table table-hover" align="center">
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>조회수</th>
                            <th>작성일</th>
                            <th>첨부파일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td colspan="6" rowspan="4" align="center">
                                <div class="spinner-border text-primary"></div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </br>
        </div>
    </div>
    <script>
        //서버로부터 조회수가 높은 게시글 5개를 조회해서 가져오기(ajax)
        //tbody요소에 추가
        function init(){
            getTopList(drawTopList);
        }

        function getTopList(callback){
            $.ajax({
                url: "/api/board/toplist.bo",
                type: "get",
                dataType: "json",
                success: callback,
                error: function (){
                    console.log("게시글 조회 실패")
                }
            })
        }

        function drawTopList(topList){
            const contentBody = document.querySelector("#top5-board-list tbody");
            let str = "";
            for(let b of topList){
                str += ("<tr onclick='moveDetail(" + b.boardNo + ")'>"
                    + "<td>" + b.boardNo + "</td>"
                    + "<td>" + b.boardTitle + "</td>"
                    + "<td>" + b.boardWriter + "</td>"
                    + "<td>" + b.count + "</td>"
                    + "<td>" + b.createDate + "</td>"
                    + "<td>" + (b.originName != null ? "★" : "") + "</td>" +
                    "</tr>")
            }
            contentBody.innerHTML = str;
        }

        function moveDetail(bno){
            location.href="/detail.bo?bno="+bno;
        }
    </script>
    <jsp:include page="common/footer.jsp" />
</body>
</html>
