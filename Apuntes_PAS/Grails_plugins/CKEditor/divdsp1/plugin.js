/**
 * Copyright (c) 2014, CKSource - Jesús Campos. All rights reserved.
 * Licensed under the terms of the MIT License (see LICENSE.md).
 *
 * Basic sample plugin inserting current date and time into the CKEditor editing area.
 *
 * Created out of the CKEditor Plugin SDK:
 * http://docs.ckeditor.com/#!/guide/plugin_sdk_intro
 */

// Register the plugin within the editor.
CKEDITOR.plugins.add( 'divdsp1', {

	// Register the icons. They must match command names.
	icons: 'divdsp1',

	// The plugin initialization logic goes inside this method.
	init: function( editor ) {

		// Define the editor command that inserts a divdsp1.
		editor.addCommand( 'insertDivdsp1', {

			// Define the function that will be fired when the command is executed.
			exec: function( editor ) {
				

				// Insert the divdsp1 into the document.
				editor.insertHtml( '<div> <!-- T&iacute;tol --> <div class=\"selectedTitol\" id=\"box_112\">  <div class=\"minus\" id=\"title_box_112\">	T&iacute;tol</div></div><!-- Contingut --><div class=\"dsplContent\" id=\"dsplContent_box_112\">Contingut </div></div>' );
			}
		});

		// Create the toolbar button that executes the above command.
		editor.ui.addButton( 'Divdsp1', {
			label: 'Insert Divdsp1',
			command: 'insertDivdsp1',
			toolbar: 'insert'
		});
	}
});
