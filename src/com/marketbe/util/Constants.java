package com.marketbe.util;

/**
 * @author junior
 * 
 * Application common constants
 */
public interface Constants
{
	/* Properties File */
	public static final String APPLICATION_MESSAGE_PROPERTIES_FILE = "application-message.properties";
	
	/* Properties File Keys */
	public static final String MESSAGE_SUCCESS_CATEGORY_DESTROY = "Categoria removida com sucesso";
	public static final String MESSAGE_SUCCESS_CATEGORY_UPDATE = "Categoria atualizada com sucesso";
	public static final String MESSAGE_SUCCESS_CATEGORY_LIST = "Categorias listadas com sucesso";
	public static final String MESSAGE_SUCCESS_CATEGORY_CREATE = "Categoria criada com sucesso";
	public static final String MESSAGE_SUCCESS_USER_CHANGE_PASSWORD = "Senha alterada com sucesso";
	public static final String MESSAGE_FAILURE_USER_CHANGE_PASSWORD_DIFF_PASSWORD = "Senhas diferentes";
	public static final String MESSAGE_FAILURE_USER_CHANGE_PASSWORD_USER_NOT_FOUND = "Usuário não encontrado, entre em contato com o administrador do sistema";
	public static final String MESSAGE_SUCCESS_USER_LOAD = "Usuário carregado com sucesso";
	public static final String MESSAGE_SUCCESS_USER_UPDATE = "Usuário atualizado com sucesso";
	
	/* Messages for validation */
	public static final String CANNOT_BE_BLANK = " é um campo requerido";
	public static final String MIN_VALUE = " não pode ser menor que ";
	public static final String BETWEEN_VALUE = " deve possuir entre ";
	public static final String INVALID = " inválido";
	
	public static final String MESSAGE_ERROR_INVALID_ID = "ID inválido ";
	/* HTTP methods */
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String PUT = "PUT";
	public static final String DELETE = "DELETE";
	public static final String HEAD = "HEAD";
	
	/* Response status */
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	
}
