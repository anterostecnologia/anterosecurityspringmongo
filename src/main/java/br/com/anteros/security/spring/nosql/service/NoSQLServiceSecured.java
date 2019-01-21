package br.com.anteros.security.spring.nosql.service;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.Optional;

import br.com.anteros.nosql.persistence.session.query.Example;
import br.com.anteros.nosql.persistence.session.query.NoSQLQuery;
import br.com.anteros.nosql.persistence.session.query.Page;
import br.com.anteros.nosql.persistence.session.query.Sort;
import br.com.anteros.nosql.persistence.session.service.NoSQLService;
import br.com.anteros.security.spring.ActionSecured;


public interface NoSQLServiceSecured<T,ID extends Serializable> extends NoSQLService<T, ID> {
	
	@ActionSecured(actionName="ACT_save", category="Edição", description="Salvar entidade")
	public <S extends T> S save(S entity) throws Exception;

	@ActionSecured(actionName="ACT_save", category="Edição", description="Salvar entidade")
	public <S extends T> Iterable<S> save(Iterable<S> entities);
	
	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Optional<T> findById(ID id);

	@ActionSecured(actionName="ACT_exists", category="Busca", description="Verifica se uma entidade existe")
	public boolean existsById(ID id);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Iterable<T> findAll();
	
	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Iterable<T> find(String query);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Iterable<T> findById(Iterable<ID> ids);
	
	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Iterable<T> find(NoSQLQuery<?> query);
	
	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Page<T> findWithPage(NoSQLQuery<?> query);
	
	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Page<T> findWithPage(NoSQLQuery<?> query, Pageable pageable);

	@ActionSecured(actionName="ACT_count", category="Edição", description="Conta a quantidade de objetos")
	public long count();

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	public void removeById(ID id);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	public void remove(T entity);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	public void remove(Iterable<? extends T> entities);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	public void removeAll();

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Iterable<T> findAll(Sort sort);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public Page<T> findAll(Pageable pageable);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public <S extends T> Optional<S> findOne(Example<S> example);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public <S extends T> Iterable<S> find(Example<S> example);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public <S extends T> Iterable<S> find(Example<S> example, Sort sort);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	public <S extends T> Page<S> find(Example<S> example, Pageable pageable);

	public <S extends T> long count(Example<S> example);

	@ActionSecured(actionName="ACT_exists", category="Busca", description="Verifica se uma entidade existe")
	public <S extends T> boolean exists(Example<S> example);
	
	
}