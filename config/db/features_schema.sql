create DATABASE features;

CREATE SCHEMA sys;

-- 用户组
DROP TABLE IF EXISTS sys.USER_GROUP;
CREATE TABLE IF NOT EXISTS sys.USER_GROUP(
  id VARCHAR(32) PRIMARY KEY ,
  group_name VARCHAR(32) NOT NULL ,
  parent_id VARCHAR(32),
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 创建用户表
DROP TABLE IF EXISTS sys.user;
CREATE TABLE IF NOT EXISTS sys.user(
  id VARCHAR(32) PRIMARY KEY ,
  user_name VARCHAR(32) NOT NULL ,
  passwor VARCHAR(125) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP,
  delete BOOLEAN DEFAULT FALSE
);

-- 创建角色表
DROP TABLE IF EXISTS sys.role;
CREATE TABLE IF NOT EXISTS sys.role(
  id VARCHAR(32) PRIMARY KEY ,
  name VARCHAR(32) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 创建权限表
DROP TABLE IF EXISTS sys.authorization;
CREATE TABLE IF NOT EXISTS sys.authorization(
  id VARCHAR(32) PRIMARY KEY ,
  type VARCHAR(5) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 用户组与用户表关联表
DROP TABLE IF EXISTS sys.user_group_associate;
CREATE TABLE IF NOT EXISTS sys.user_group_associate(
  id VARCHAR(5) PRIMARY KEY ,
  group_id VARCHAR(32) NOT NULL ,
  user_id VARCHAR(32) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 用户组与角色表关联表
DROP TABLE IF EXISTS sys.role_group_associate;
CREATE TABLE IF NOT EXISTS sys.role_group_associate(
  id VARCHAR(5) PRIMARY KEY ,
  group_id VARCHAR(32) NOT NULL ,
  role_id VARCHAR(32) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 权限与角色表关联表
DROP TABLE IF EXISTS sys.role_authorization_associate;
CREATE TABLE IF NOT EXISTS sys.role_authorization_associate(
  id VARCHAR(5) PRIMARY KEY ,
  authorization_id VARCHAR(32) NOT NULL ,
  role_id VARCHAR(32) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);
-- 菜单表
DROP TABLE IF EXISTS sys.menu;
CREATE TABLE IF NOT EXISTS sys.menu(
  id VARCHAR(32) PRIMARY KEY ,
  parent_id VARCHAR(32) NOT NULL ,
  name VARCHAR(32) NOT NULL ,
  url VARCHAR(32),
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);

-- 权限与菜单表关联表
DROP TABLE IF EXISTS sys.menu_authorization_associate;
CREATE TABLE IF NOT EXISTS sys.menu_authorization_associate(
  id VARCHAR(5) PRIMARY KEY ,
  authorization_id VARCHAR(32) NOT NULL ,
  menu_id VARCHAR(32) NOT NULL,
  ctime TIMESTAMP NOT NULL ,
  mtime TIMESTAMP
);