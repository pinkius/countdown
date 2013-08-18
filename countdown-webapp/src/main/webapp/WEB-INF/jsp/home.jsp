<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>Webster Smalley Countdown Solver</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <style>
	body
	{
		background-color:#ffffff;
		margin-top:-0px;
		margin-left:-0px;
	}

	#wrap
	{
		overflow:auto;
		width:320px;
		height:480px;

	}

	#header
	{
		height:50px;

	}

	#content
	{
		margin-top:-5px;

	}

	p
	{
		margin:5px;
		padding-left:25px;
		width:270px;
		font-size:10px;
		font-family:arial,"san serif";
	}

	#bottom
	{
		height:31px;
		margin-top:-5px;
	}
</style>
    </head>
    <body>
    <div id="wrap">
        <div id="header">Webster-Smalley Countdown Solver</div>
        Letters: <input id="letters" name="letters" onKeyUp="loadLetters()" value="GREYHOUND"></input>
        Numbers: <input id="numbers" name="numbers" onKeyUp="loadNumbers()" value="1,2,3,4,5,6,100"></input>

        <iframe src="about:blank" id="resultsFrame"></iframe>
        <div id="bottom">Not affiliated with Countdown in any way.</div>
    </div>
    <script>
        var lastLetters = "";
        var lastNumbers = "";
        function loadLetters() {
            if (document.getElementById('resultsFrame').src.indexOf("solveLetters") <0 || lastLetters != document.getElementById('letters').value) {
                lastLetters = document.getElementById('letters').value;
                document.getElementById('resultsFrame').src = "solveLetters.html?letters=" + document.getElementById('letters').value;
            }
        }
        function loadNumbers() {
            if (document.getElementById('resultsFrame').src.indexOf("solveNumbers") <0 || lastNumbers != document.getElementById('numbers').value) {
                lastNumbers = document.getElementById('numbers').value;
                document.getElementById('resultsFrame').src = "solveNumbers.html?numbers=" + document.getElementById('numbers').value;
            }

        }
    </script>
    </body>
</html>
