<html>
<head>
    <title>Custom Content</title>
    <style type="text/css"></style>
</head>
<body>
<div>
    <form id="Poll" action="submit.jspa" method="post">
        <div>
            <div style="display:inline">
                <label for="question">Question</label>
                <input id="question" type="text" name= "question">
            </div>

            <div style="display:inline">
                <p>
                    <label for="option1">Option 1</label>
                    <input id="option1" type="text" name="option1"/>
                </p>
                <p>
                    <label for="option2">Option 2</label>
                    <input id="option2" type="text" name="option2"/>
                </p>
                <p>
                    <label for="option3">Option 3</label>
                    <input id="option3" type="text" name="option3"/>
                </p>
            </div>
            <button type= "submit" name = "send">Create</button>
        </div>

    </form>
</div>
</body>
</html>