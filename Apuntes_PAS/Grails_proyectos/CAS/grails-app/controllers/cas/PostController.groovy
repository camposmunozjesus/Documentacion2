package cas
import grails.plugin.springsecurity.annotation.Secured

import com.jesuscampos.security.SecUser
@Secured(['ROLE_ADMIN'])
class PostController {

	def springSecurityService

	
	def timeline = {
		def user = SecUser.get(springSecurityService.principal.id)

		def posts = []
//		if (user.following) {
////			posts = Post.withCriteria {
////				'in'("user", user.following)
////				order("createdOn", "desc")
////			}
//			posts= ['jesus','campos']
//		}
		[ posts: posts, postCount: posts.size() ]
	}
}
