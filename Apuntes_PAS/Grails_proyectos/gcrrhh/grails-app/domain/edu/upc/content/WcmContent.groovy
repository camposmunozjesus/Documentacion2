package edu.upc.content

class WcmContent implements Comparable{
	
	static MAX_CONTENT_SIZE = 500000
	
	int identity
	String aliasuri
//	String name
	String title
	String content
	int space
	Integer tmpl
	String type
	
	//
	String keywords
	String menuTitle
	String htmlTitle
	String description
	Integer status
	
	//
	def absoluteURI
	Integer parent
	Integer order_index
	
	def children
	
	String changed_by
	String changed_on
	
	static mapping = {
		table name: "wcm_content"
		id name:'identity'
		id generator:'assigned'
		version false
		
		identity column: 'id'
		space column: 'space_id'
		tmpl column: 'template_id'
		type column: 'class'
		menuTitle column: 'menu_title'
		htmlTitle column: 'html_title'
		status column: 'status_id'
		parent column: 'parent_id'

	}
			
	static constraints = {
		content(nullable: false, maxSize: this.MAX_CONTENT_SIZE)

	}


	@Override
	public int compareTo(Object o) {
		if (this.is(o)) return 0
		// NOTE: the orderIndex == a.orderIndex returning -1 is REQUIRED with Grails 1.1.1 to workaround
		// issues where orderIndex for children is not unique - returning 0 stops a node being returned in the set!
		if (!o || (o.title == null) || (o.title == title)) return -1
		this.title <=> o.title
	
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((absoluteURI == null) ? 0 : absoluteURI.hashCode());
		result = prime * result
				+ ((aliasuri == null) ? 0 : aliasuri.hashCode());
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((htmlTitle == null) ? 0 : htmlTitle.hashCode());
		result = prime * result + identity;
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result
				+ ((menuTitle == null) ? 0 : menuTitle.hashCode());
		result = prime * result
				+ ((order_index == null) ? 0 : order_index.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + space;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tmpl == null) ? 0 : tmpl.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WcmContent other = (WcmContent) obj;
		if (absoluteURI == null) {
			if (other.absoluteURI != null)
				return false;
		} else if (!absoluteURI.equals(other.absoluteURI))
			return false;
		if (aliasuri == null) {
			if (other.aliasuri != null)
				return false;
		} else if (!aliasuri.equals(other.aliasuri))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (htmlTitle == null) {
			if (other.htmlTitle != null)
				return false;
		} else if (!htmlTitle.equals(other.htmlTitle))
			return false;
		if (identity != other.identity)
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (menuTitle == null) {
			if (other.menuTitle != null)
				return false;
		} else if (!menuTitle.equals(other.menuTitle))
			return false;
		if (order_index == null) {
			if (other.order_index != null)
				return false;
		} else if (!order_index.equals(other.order_index))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (space != other.space)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tmpl == null) {
			if (other.tmpl != null)
				return false;
		} else if (!tmpl.equals(other.tmpl))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



}
	
	
	
	
