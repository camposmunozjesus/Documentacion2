package org.weceem.auth

class CMSRoleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
		println "----------------->"+"[CMSRoleController::index]"
        redirect(action: "list", params: params)
    }

    def list = {
		println "----------------->"+"[CMSUserController::list]"
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [CMSRoleInstanceList: CMSRole.list(params), CMSRoleInstanceTotal: CMSRole.count()]
    }

    def create = {
		println "----------------->"+"[CMSRoleController::create]"
        def CMSRoleInstance = new CMSRole()
        CMSRoleInstance.properties = params
        return [CMSRoleInstance: CMSRoleInstance]
    }

    def save = {
		println "----------------->"+"[CMSRoleController::save]"
        def CMSRoleInstance = new CMSRole(params)
        if (CMSRoleInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), CMSRoleInstance.id])}"
            redirect(action: "show", id: CMSRoleInstance.id)
        }
        else {
            render(view: "create", model: [CMSRoleInstance: CMSRoleInstance])
        }
    }

    def show = {
		println "----------------->"+"[CMSRoleController::show]"
        def CMSRoleInstance = CMSRole.get(params.id)
        if (!CMSRoleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
            redirect(action: "list")
        }
        else {
            [CMSRoleInstance: CMSRoleInstance]
        }
    }

    def edit = {
		println "----------------->"+"[CMSRoleController::edit]"
        def CMSRoleInstance = CMSRole.get(params.id)
        if (!CMSRoleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [CMSRoleInstance: CMSRoleInstance]
        }
    }

    def update = {
		println "----------------->"+"[CMSRoleController::update]"
        def CMSRoleInstance = CMSRole.get(params.id)
        if (CMSRoleInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (CMSRoleInstance.version > version) {
                    
                    CMSRoleInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'CMSRole.label', default: 'CMSRole')] as Object[], "Another user has updated this CMSRole while you were editing")
                    render(view: "edit", model: [CMSRoleInstance: CMSRoleInstance])
                    return
                }
            }
            CMSRoleInstance.properties = params
            if (!CMSRoleInstance.hasErrors() && CMSRoleInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), CMSRoleInstance.id])}"
                redirect(action: "show", id: CMSRoleInstance.id)
            }
            else {
                render(view: "edit", model: [CMSRoleInstance: CMSRoleInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
		println "----------------->"+"[CMSRoleController::delete]"
        def CMSRoleInstance = CMSRole.get(params.id)
        if (CMSRoleInstance) {
            try {
                CMSRoleInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSRole.label', default: 'CMSRole'), params.id])}"
            redirect(action: "list")
        }
    }
}
