PGDMP         #                {         
   patrimonio    14.2    14.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    40960 
   patrimonio    DATABASE     j   CREATE DATABASE patrimonio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE patrimonio;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    40963    marcas    TABLE     X   CREATE TABLE public.marcas (
    id bigint NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.marcas;
       public         heap    postgres    false    3            �            1259    40962    marcas_id_seq    SEQUENCE     �   ALTER TABLE public.marcas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.marcas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210    3            �            1259    40969    patrimonios    TABLE     �   CREATE TABLE public.patrimonios (
    id bigint NOT NULL,
    descricao character varying(255),
    marca_id bigint,
    nome character varying(255),
    num_tombo bigint
);
    DROP TABLE public.patrimonios;
       public         heap    postgres    false    3            �            1259    40968    patrimonios_id_seq    SEQUENCE     �   ALTER TABLE public.patrimonios ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.patrimonios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212    3            �          0    40963    marcas 
   TABLE DATA           *   COPY public.marcas (id, nome) FROM stdin;
    public          postgres    false    210            �          0    40969    patrimonios 
   TABLE DATA           O   COPY public.patrimonios (id, descricao, marca_id, nome, num_tombo) FROM stdin;
    public          postgres    false    212            �           0    0    marcas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.marcas_id_seq', 6, true);
          public          postgres    false    209            �           0    0    patrimonios_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.patrimonios_id_seq', 10, true);
          public          postgres    false    211            b           2606    40967    marcas marcas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_pkey;
       public            postgres    false    210            d           2606    40975    patrimonios patrimonios_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.patrimonios
    ADD CONSTRAINT patrimonios_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.patrimonios DROP CONSTRAINT patrimonios_pkey;
       public            postgres    false    212            �   A   x�3�t�q�2��q����2�ttv�2��MLI�,JT��\f@���D��T���҂D�=... H      �   �   x����jQ��O�/�p��)��XHҥِ����*>~FI��p8���v^��<�_����c?��-�0W�f���9�u��Әۿ��e�Y��HY,"�� ���Be'�$�0K�k��v�{6�jH�lZ�8,��������	M%򊦔W"+X�ҏ�>}�v����6vVJ������R�/�IG�          �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    40960 
   patrimonio    DATABASE     j   CREATE DATABASE patrimonio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE patrimonio;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    40963    marcas    TABLE     X   CREATE TABLE public.marcas (
    id bigint NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.marcas;
       public         heap    postgres    false    3            �            1259    40962    marcas_id_seq    SEQUENCE     �   ALTER TABLE public.marcas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.marcas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210    3            �            1259    40969    patrimonios    TABLE     �   CREATE TABLE public.patrimonios (
    id bigint NOT NULL,
    descricao character varying(255),
    marca_id bigint,
    nome character varying(255),
    num_tombo bigint
);
    DROP TABLE public.patrimonios;
       public         heap    postgres    false    3            �            1259    40968    patrimonios_id_seq    SEQUENCE     �   ALTER TABLE public.patrimonios ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.patrimonios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212    3            �          0    40963    marcas 
   TABLE DATA           *   COPY public.marcas (id, nome) FROM stdin;
    public          postgres    false    210   V       �          0    40969    patrimonios 
   TABLE DATA           O   COPY public.patrimonios (id, descricao, marca_id, nome, num_tombo) FROM stdin;
    public          postgres    false    212   K        �           0    0    marcas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.marcas_id_seq', 6, true);
          public          postgres    false    209            �           0    0    patrimonios_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.patrimonios_id_seq', 10, true);
          public          postgres    false    211            b           2606    40967    marcas marcas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_pkey;
       public            postgres    false    210            d           2606    40975    patrimonios patrimonios_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.patrimonios
    ADD CONSTRAINT patrimonios_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.patrimonios DROP CONSTRAINT patrimonios_pkey;
       public            postgres    false    212           