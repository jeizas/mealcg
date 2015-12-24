package com.jeizas.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("all")
@Repository
public class BaseDAO<T>{
	
	
	protected SessionFactory sessionFactory;//��sessionд�����Dao��


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
//		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return new Long((long)this.getCurrentSession().createQuery(hql).list().size());
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		int size = q.list().size();
		return new Long((long)size);
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		int size = q.list().size();
		return new Long((long)size);
	}

	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	public List<List<? extends Object>> getListByCheckArray(String hql,List<Object> param) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
//		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		System.out.println(hql);	
			System.out.println("daoImp:"+q.list().size()+": "+q.list());
		
		return q.list();
	}

	public List<List<? extends Object>> getListByCheckArrayPage(String hql,
			List<Object> param, Integer startRow, Integer pageSize) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
			
		return q.setFirstResult(startRow).setMaxResults(pageSize).list();
	}
//原生sql

	public Integer updateBySQL(String sql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	public T getBySQL(String sql) {
		// TODO Auto-generated method stub
		List<T> l = this.findListBySQL(sql);
		if( l != null && l.size()  > 0)
			return l.get(0);
		return null;
	}

	public List<T> findListBySQL(String sql) {
		// TODO Auto-generated method stub
		ParameterizedType p = (ParameterizedType) getClass().getGenericSuperclass();
		return this.getCurrentSession().createSQLQuery(sql).addEntity((Class)p.getActualTypeArguments()[0]).list();
		/*
		 * 	private Class entityT;	
		public BaseDAOImpl(){
		ParameterizedType p = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.entityT = (Class) p.getActualTypeArguments()[0];
		}
		return this.getCurrentSession().createSQLQuery(sql).addEntity(entityT).list();
		 */
		
	}
	public T getBySQL(String sql, Class<T> entity) {
		// TODO Auto-generated method stub
		List<T> l = this.findListBySQL(sql, entity);
		if( l != null && l.size()  > 0)
			return l.get(0);
		return null;
	}
	public List<T> findListBySQL(String sql, Class<T> entity) {
		return this.getCurrentSession().createSQLQuery(sql).addEntity(entity).list();
	}

	public Integer updateBySQL(String sql, Class<T> entity) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createSQLQuery(sql).addEntity(entity).executeUpdate();
	}
	
	public T getObjectBySQL(String sql) {
		// TODO Auto-generated method stub
		List<T> l=this.findObjectBySQL(sql);
		if(l != null && l.size()>0)
			return l.get(0);
		else
			return null;
	}
	public List<T> findObjectBySQL(String sql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createSQLQuery(sql).list();
	}
	public int updateObjectBySQL(String sql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	public List findBySQL(String sql) {
		// TODO Auto-generated method stub
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	public List findListBySQL(String sql,
			Map<String, org.hibernate.type.Type> types, int firstRow,
			int numRows) {
		// TODO Auto-generated method stub
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		for (Map.Entry<String, Type> kvp : types.entrySet()) {
			sqlQuery.addScalar(kvp.getKey(), kvp.getValue());
		}		
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if (firstRow >= 0 && numRows > 0) {
			sqlQuery.setFirstResult(firstRow);
			sqlQuery.setMaxResults(numRows);
		}
		
		return sqlQuery.list();
	}

	public List<T> findBySQL(String sql, int firstRow, int numRows) {
		// TODO Auto-generated method stub
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if(firstRow >= 0 && numRows > 0)
			query.setFirstResult(firstRow).setMaxResults(numRows);
		return query.list();
	}

	public List<T> findObjectBySQL(String sql, int firstRow, int numRows) {
		// TODO Auto-generated method stub
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);		
		if(firstRow >= 0 && numRows > 0)
			query.setFirstResult(firstRow).setMaxResults(numRows);
		return query.list();
	}

	public long countBySQL(String sql) {
		// TODO Auto-generated method stub
		return Long.parseLong((this.getCurrentSession().createSQLQuery(sql).uniqueResult()).toString());
	}
}
