
App = {};



Ext.Ajax.defaultHeaders = {
    'Accept': 'application/json'
};


${className} = Ext.data.Record.create(${fields});



App.getStore = function() {
  return new Ext.data.Store({
        id: 'id',
        restful:true,
        proxy: new Ext.data.HttpProxy({url:'/jackson/${className}'}),

        <%--proxy: new Ext.data.HttpProxy({--%>
        <%--api: {--%>
            <%--read : {url: '/jackson/${className}', method: 'GET'},--%>
            <%--create : {url: '/jackson/${className}', method: 'PUT'},--%>
            <%--update: {url: '/jackson/${className}', method: 'POST'},--%>
            <%--destroy: {url: '/jackson/${className}', method: 'DELETE'},--%>
        <%--}--%>
        <%--}),--%>
        reader: new Ext.data.JsonReader({
                totalProperty: 'total',
                successProperty: 'success',
                // todo: carregar do modelo.
                idProperty: 'field2',
                root: 'data',
                messageProperty: 'message'  // <-- New "messageProperty" meta-data
            }, ${className}),
        writer: new Ext.data.JsonWriter({
            encode: true,
            writeAllFields: true
        }),// <-- plug a DataWriter into the store just as you would a Reader
        autoSave: false// <-- false would delay executing create, update, destroy requests until specifically told to do so with some [save] buton.
    });
}
