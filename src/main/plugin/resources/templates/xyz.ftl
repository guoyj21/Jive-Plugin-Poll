<html>
<head>
    <#--<script src="http://localhost:8080/resources/scripts/jquery/jquery.json.js"></script>-->
    <script>
        $j(document).ready(function () {
            $j("button").click(function () {
                $j.ajax({
                    url: "abc.jspa",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    data:"{'option1': 'Soham', 'option2': 'Bangalore', 'option3': 'Calcutta'}",
                    success: function (result) {
                        alert("success");
                    },
                    error: function (result) {
                        alert("error");
                    }
                });
            });
        });
    </script>
</head>
<body>
<button>Send an HTTP POST request to a page and get the result back</button>
</body>
</html>