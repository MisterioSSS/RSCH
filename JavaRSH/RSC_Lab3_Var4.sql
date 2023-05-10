PGDMP                         z            RSC_Lab3    14.2    14.2     #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            &           1262    212992    RSC_Lab3    DATABASE     g   CREATE DATABASE "RSC_Lab3" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "RSC_Lab3";
                postgres    false                        3079    212993 	   uuid-ossp 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
    DROP EXTENSION "uuid-ossp";
                   false            '           0    0    EXTENSION "uuid-ossp"    COMMENT     W   COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';
                        false    2            �            1259    213004    authors    TABLE     E   CREATE TABLE public.authors (
    name character varying NOT NULL
);
    DROP TABLE public.authors;
       public         heap    postgres    false            �            1259    213011    books    TABLE     �   CREATE TABLE public.books (
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    pagecount integer NOT NULL,
    yearofissue integer NOT NULL,
    author character varying
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    213060    flyway_schema_history    TABLE     �  CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
 )   DROP TABLE public.flyway_schema_history;
       public         heap    postgres    false            �            1259    213023    roles    TABLE     C   CREATE TABLE public.roles (
    name character varying NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    213045    tokens    TABLE     y   CREATE TABLE public.tokens (
    user_id uuid NOT NULL,
    value character varying(255) NOT NULL,
    killed boolean
);
    DROP TABLE public.tokens;
       public         heap    postgres    false            �            1259    213030    users    TABLE     )  CREATE TABLE public.users (
    id uuid NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    role character varying,
    email character varying(25) NOT NULL,
    password character varying(120) NOT NULL,
    enabled boolean DEFAULT true
);
    DROP TABLE public.users;
       public         heap    postgres    false                      0    213004    authors 
   TABLE DATA           '   COPY public.authors (name) FROM stdin;
    public          postgres    false    210   d!                 0    213011    books 
   TABLE DATA           I   COPY public.books (id, name, pagecount, yearofissue, author) FROM stdin;
    public          postgres    false    211   �!                  0    213060    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    215   �!                 0    213023    roles 
   TABLE DATA           %   COPY public.roles (name) FROM stdin;
    public          postgres    false    212   �!                 0    213045    tokens 
   TABLE DATA           8   COPY public.tokens (user_id, value, killed) FROM stdin;
    public          postgres    false    214   �!                 0    213030    users 
   TABLE DATA           Z   COPY public.users (id, first_name, last_name, role, email, password, enabled) FROM stdin;
    public          postgres    false    213   �"       }           2606    213010    authors authors_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (name);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public            postgres    false    210                       2606    213017    books books_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    211            �           2606    213067 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     x   ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 X   ALTER TABLE ONLY public.flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
       public            postgres    false    215            �           2606    213029    roles roles_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (name);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    212            �           2606    213049    tokens tokens_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_pkey PRIMARY KEY (user_id);
 <   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_pkey;
       public            postgres    false    214            �           2606    213051    tokens tokens_value_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_value_key UNIQUE (value);
 A   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_value_key;
       public            postgres    false    214            �           2606    213043    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    213            �           2606    213036    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    213            �           1259    213068    flyway_schema_history_s_idx    INDEX     `   CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);
 /   DROP INDEX public.flyway_schema_history_s_idx;
       public            postgres    false    215            �           2606    213018    books fk_authors    FK CONSTRAINT     r   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk_authors FOREIGN KEY (author) REFERENCES public.authors(name);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT fk_authors;
       public          postgres    false    210    211    3197            �           2606    213037    users fk_roles    FK CONSTRAINT     l   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_roles FOREIGN KEY (role) REFERENCES public.roles(name);
 8   ALTER TABLE ONLY public.users DROP CONSTRAINT fk_roles;
       public          postgres    false    212    213    3201            �           2606    213052    tokens tokens_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_user_id_fkey;
       public          postgres    false    213    3205    214                  x������ � �            x������ � �             x������ � �            x�v�rt�������� "3e         �   x���
�0 ೾�2u�<��L�'#�&]t&mi�>�~�O�p��;Q8o|��$@�^v�1
�˒_�L�R���'�#w534�o�vf�x+(`3���c��UV��y������ e�k�O�ժH�8qU���ր_��'��X&4�J��t�`=��>��m� �7c         �   x����   �3<�W�#q��j�VDk�uA�٦i&���w�*ׂ;�D�8b�#^˲�UT3L����\߂D���p����Gb���2�S�|
�g��j�$�z�U�?_���ɐS���Sj��ꁀ	�B��a(     