<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String title = "Supply";%>
<%@include file="header&menu.jsp" %>


<script>
    var d = document;

    var name;
    var initials;
    var posada;

    function addRow()
    {
        // Считываем значения с формы
        name = d.getElementById('name').value;
        type = d.getElementById('type').value;
        qnt = d.getElementById('qnt').value;
        price = d.getElementById('price').value;

        // Находим нужную таблицу
        var tbody = d.getElementById('tab1').getElementsByTagName('TBODY')[0];

        // Создаем строку таблицы и добавляем ее
        var row = d.createElement("TR");
        tbody.appendChild(row);

        // Создаем ячейки в вышесозданной строке
        // и добавляем тх
        var td1 = d.createElement("TD");
        var td2 = d.createElement("TD");
        var td3 = d.createElement("TD");
        var td4 = d.createElement("TD");

        row.appendChild(td1);
        row.appendChild(td2);
        row.appendChild(td3);
        row.appendChild(td4);

        // Наполняем ячейки
        td1.innerHTML = type;
        td2.innerHTML = name;
        td3.innerHTML = qnt;
        td4.innerHTML = price;
    }
</script>
<div class="col-lg-6">
<form action="" id="add_persons" method="post" onsubmit="addRow();return false;">
    <fieldset>
        <legend>Add</legend>

        <table class="table" style="border: 0px">
            <tr>
                <td><label for="type">Product type</label></td>
                <td><select class="form-control" name="type" id="type">
                    <c:forEach items="${listOfProducts}" var="option">
                        <option><c:out value="${option.name}"/></option>
                    </c:forEach>
                </select>
                </td>

            </tr>
        <tr>
             <td><label for="name">Product name</label></td>
             <td><input class = "form-control" type="text" name="name" id="name" value="" size="12" tabindex="1" /></td>

        </tr>
        <tr>
                <td><label for="qnt">Quantity</label></td>
            <td><input class = "form-control" type="text" name="qnt" id="qnt" value="" size="12" tabindex="2" /></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td><input class = "form-control" type="text" name="price" id="price" value="" size="12" tabindex="3" /></td>
        </tr>
        <tr>
            <td><label>Add product</label></td>
            <td><button class="btn btn-group-lg btn-default" type="submit" onclick="addRow('tab1');return false;">Add</button></td>
        </tr>
        </table>

    </fieldset>
</form>
</div>

    <table id="tab1" cellspacing="0" class="table">
        <tbody>
        <tr>
            <td>Product type</td><td>Product name</td><td>Quantity</td><td>Price</td>
        </tr>
        </tbody>
    </table>

<%@include file="footer.jsp" %>