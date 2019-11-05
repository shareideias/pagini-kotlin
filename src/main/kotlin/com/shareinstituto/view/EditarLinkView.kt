package com.shareinstituto.view

import com.shareinstituto.model.dao.DataAccessObject
import io.javalin.http.Context
import kotlinx.html.*
import kotlinx.html.ButtonType.submit

class EditarLinkView(dao: DataAccessObject) : AdminModeloView(dao) {
    override val pageTitle = "Nova Página"
    override val extraCss = listOf("/css/administração.css")
    override val mainPage = "/admin"

    override fun MAIN.renderMain(ctx: Context) {
        div("container") {
            h5("underlined") { +"Nova Página" }
            form(method = FormMethod.post) {
                div("row") {
                    div(classes = "input-field col s8") {
                        label {
                            htmlFor = "inputTitle"
                            +"Título da página"
                        }
                        input(type = InputType.text, classes = "validate") {
                            placeholder = "Título"
                            id = "inputTitle"
                            name = "title"
                        }
                    }

                    div(classes = "input-field col s4") {
                        label {
                            htmlFor = "inputLink"
                            +"Link da página"
                        }
                        input(type = InputType.text, classes = "validate") {
                            placeholder = "/link_da_pagina"
                            id = "inputLink"
                            name = "linkPagina"
                        }
                    }

                    div("col s12") {
                        label {
                            +"Corpo da página"
                        }
                        textArea {
                            id = "summernote"
                            name = "html"
                        }
                    }

                    div("col s12 input-field") {
                        button(classes = "btn waves-effect light-blue lighten-2", type = submit) {
                            +"Criar Página"
                            i("material-icons right") { +"send" }
                        }
                    }
                }
            }
        }
    }

    override fun HEAD.extraLinks() {
        link(href = "https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css", rel = "stylesheet")
    }

    override fun BODY.extraScripts() {
        script(src = "http://code.jquery.com/jquery-3.4.1.min.js") {}
        script(src = "https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js") {}
        script(src = "https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-pt-BR.min.js") {}
        script {
            unsafe {
                +"""
                $(document).ready(function() {
                    $('#summernote').summernote({ height: 400, lang: 'pt-BR' });
                })
                """.trimIndent()
            }
        }
    }
}