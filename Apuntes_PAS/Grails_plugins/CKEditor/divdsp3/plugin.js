/**
 * Copyright (c) 2014, CKSource - Frederico Knabben. All rights reserved.
 * Licensed under the terms of the MIT License (see LICENSE.md).
 *
 * Basic sample plugin inserting abbreviation elements into the CKEditor editing area.
 *
 * Created out of the CKEditor Plugin SDK:
 * http://docs.ckeditor.com/#!/guide/plugin_sdk_sample_1
 */

// Register the plugin within the editor.
CKEDITOR.plugins.add( 'divdsp3', {

	// Register the icons.
	icons: 'divdsp3',

	// The plugin initialization logic goes inside this method.
	init: function( editor ) {

		// Define an editor command that opens our dialog window.
		editor.addCommand( 'divdsp3', new CKEDITOR.dialogCommand( 'divdsp3Dialog' ) );

		// Create a toolbar button that executes the above command.
		editor.ui.addButton( 'Divdsp3', {

			// The text part of the button (if available) and the tooltip.
			label: 'Insert Divdsp3',

			// The command to execute on click.
			command: 'divdsp3',

			// The button placement in the toolbar (toolbar group name).
			toolbar: 'insert'
		});

		// Register our dialog file -- this.path is the plugin folder path.
		CKEDITOR.dialog.add( 'divdsp3Dialog', this.path + 'dialogs/divdsp3.js' );
	}
});
