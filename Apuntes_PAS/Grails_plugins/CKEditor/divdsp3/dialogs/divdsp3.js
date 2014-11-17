/**
 * Copyright (c) 2014, CKSource - Frederico Knabben. All rights reserved.
 * Licensed under the terms of the MIT License (see LICENSE.md).
 *
 * The abbr plugin dialog window definition.
 *
 * Created out of the CKEditor Plugin SDK:
 * http://docs.ckeditor.com/#!/guide/plugin_sdk_sample_1
 */

// Our dialog definition.
CKEDITOR.dialog.add( 'divdsp3Dialog', function( editor ) {
	return {

		// Basic properties of the dialog window: title, minimum size.
		title: 'Atributs de l\'element desplegable',
		minWidth: 300,
		minHeight: 150,

		// Dialog window content definition.
		contents: [
			{
				// Definition of the Basic Settings dialog tab (page).
				id: 'tab-basic',
				label: 'Atributs d\'element desplegable',

				// The tab content.
				elements: [
					{
						// Text input field for the abbreviation text.
						type: 'text',
						id: 'id',
						label: 'Identificador',

						// Validation checking whether the field is not empty.
						validate: CKEDITOR.dialog.validate.notEmpty( "L\'identificador no pot estar buit." )
					}
				]
			}
		],

		
		// This method is invoked once a user clicks the OK button, confirming the dialog.
		onOk: function() {

			// The context of this function is the dialog object itself.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.dialog
			var dialog = this;

			var id = dialog.getValueOf( 'tab-basic', 'id' );
			//alert(id);

			editor.insertHtml( '<div class=\"dsplGroup\"> <!-- T&iacute;tol --> <div class=\"selectedTitol\" id=\"box_'+id+'\">  <div class=\"minus\" id=\"title_box_'+id+'\">	T&iacute;tol</div></div><!-- Contingut --><div class=\"dsplContent\" id=\"dsplContent_box_'+id+'\">Contingut </div></div>' );
		}
	
	};
});
