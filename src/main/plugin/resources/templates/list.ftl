<html>
<head>
    <title>List</title></head>
     <body>
        <table>
        <#list polls as poll>
            <tr>
               <th>Question</th>
                  <#assign size = poll.optionsCount>
                    <#list 1..size as index>
                        <th>option ${index}</th>
                    </#list>
             </tr>
            <tr>
                <td>${poll.question}</td>
                <#list poll.options as option>
                     <td>${option}</td>
                </#list>
            </tr>
            </#list>
        </table>
     </body>
</html>