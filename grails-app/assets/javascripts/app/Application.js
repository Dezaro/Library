/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('Library.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Library',

    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
		 Ext.Ajax.request({
     url: 'http://localhost:8080/article/1',

     success: function(response, opts) {
         var obj = Ext.decode(response.responseText);
         console.dir(obj);
     },

     failure: function(response, opts) {
         console.log('server-side failure with status code ' + response.status);
     }
 });
        Ext.Msg.alert('Status', 'Changes saved successfully.');
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
