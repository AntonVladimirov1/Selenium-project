package UI_Testing.TicTacToe;

public class HtmlPage {

    public static final String PAGE = """
<!DOCTYPE html>
<html>
<head>
<title>Tic Tac Toe</title>
<style>
  table { border-collapse: collapse; }
  td {
    width: 80px; height: 80px;
    border: 2px solid black;
    font-size: 48px;
    text-align: center;
    cursor: pointer;
  }
</style>
</head>
<body>

<h2>Tic Tac Toe</h2>
<table id="board"></table>

<script>
let board = [
 [' ',' ',' '],
 [' ',' ',' '],
 [' ',' ',' ']
];

function draw() {
  let html = "";
  for (let i=0;i<3;i++) {
    html += "<tr>";
    for (let j=0;j<3;j++) {
      html += `<td onclick="move(${i},${j})">${board[i][j]}</td>`;
    }
    html += "</tr>";
  }
  document.getElementById("board").innerHTML = html;
}

function move(r,c) {
  fetch(`/move?row=${r}&col=${c}`)
    .then(res => res.json())
    .then(data => {
      board = data.board;
      draw();
      if (data.winner) alert("Winner: " + data.winner);
    });
}

draw();
</script>
</body>
</html>
""";
}
