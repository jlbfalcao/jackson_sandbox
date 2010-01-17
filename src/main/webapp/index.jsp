<link rel="stylesheet" href="http://www.extjs.com/deploy/dev/resources/css/ext-all.css" type="text/css"/>
<script type="text/javascript" src="http://www.extjs.com/deploy/dev/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="http://www.extjs.com/deploy/dev/ext-all.js"></script>

<!-- gerado dinamicamente -->
<script type="text/javascript" src="/jackson/fake.js"></script>

<script type="text/javascript">


    Ext.Ajax.on('beforerequest', function(conn, options) {

        if ( options.params.id ) {
            options.url += "/" + options.params.id;
            delete options.params.id;
        }

        console.debug(arguments)


    })


    Ext.onReady(function() {

        // experimente.
        var store = App.getStore();


        store.load() // carrega /fake
        store.load({params:{id:23}}) // => /fake/23
        store.getById(23).set("field1", "novovalor");
        store.save(); //=> POST /fake/23


        store.add(new fake());
        store.save() // -> PUT /fake

        store.remove(1);
        store.save(); // -> DELETE /fake/1




    })


</script>