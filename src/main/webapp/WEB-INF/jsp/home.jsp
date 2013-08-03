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
        <form id="lettersForm" action="solveLetters.html" method="POST" target="resultsFrame">
            Letters: <input id="letters" name="letters" onKeyUp="document.getElementById('lettersForm').submit()" value="GREYHOUND"></input>
        </form>
        <form id="numbersForm" action="solveNumbers.html" method="POST" target="resultsFrame">
            Numbers: <input id="numbers" name="numbers" value="1,2,3,4,5,6,100"></input>
        </form>

        <iframe src="about:blank" id="resultsFrame"></iframe>
        <div id="bottom">Not affiliated with Countdown in any way.</div>
    </div>
    </body>
</html>
