package com.upc

import org.weceem.content.WcmContent
import org.weceem.content.TemplateUtils
import org.weceem.util.ContentUtils

/**
 * This is your Weceem content domain class. See the documentation at http://weceem.org for full details
 * 
 * Summary: Add normal GORM properties for your custom content fields, including any relationships you need.
 * For non-standard types or associations you will need to implement custom wcm:editorXXXX tags to provide
 * editors for these. See the Weceem Plugin source for details (EditorTagLib.groovy)
 */
class WcmMenuGestor extends WcmContent {

    static transients = WcmContent.transients

    static icon = [plugin: "weceem", dir: "_weceem/images/weceem/content-icons", file: "folder-32.png"]

    static standaloneContent = false
    
    static searchable = {
        alias WcmMenuGestor.name.replaceAll("\\.", '_')
        only = ['title', 'status']
    }
}
