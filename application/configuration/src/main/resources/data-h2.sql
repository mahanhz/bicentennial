-- Countries
INSERT INTO COUNTRY_T(id, locale, created_date, created_by, last_modified_date, last_modified_by, version) VALUES('se', 'sv', systimestamp, 'mahan', systimestamp, 'mahan', 0);

-- Clusters
INSERT INTO CLUSTER_T(id, name, country_id, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(1, 'stockholm', 'se', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO CLUSTER_T(id, name, country_id, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(2, 'umea', 'se', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO CLUSTER_T(id, name, country_id, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(3, 'malmo', 'se', systimestamp, 'mahan', systimestamp, 'mahan', 0);

-- Events
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(1, 'se', 'stockholm', 'Jaktvillan', 59.386164, 17.983946, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(2, 'se', 'stockholm', 'Hallonbergen Centrum', 59.375335, 17.969036, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(3, 'se', 'stockholm', 'Solna Centrum', 59.359850, 18.000708, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(4, 'se', 'stockholm', 'Husby Centrum', 59.410256, 17.925624, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(5, 'se', 'stockholm', 'Flemingsberg Centrum', 59.217934, 17.945654, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(6, 'se', 'stockholm', 'Tumba Centrum', 59.199755, 17.835625, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(7, 'se', 'umea', 'Umea Centrum', 63.829998, 20.266754, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
INSERT INTO EVENT_T(id, country, cluster, address_line, latitude, longitude, name, email, phone_number, info, created_date, created_by, last_modified_date, last_modified_by, version) VALUES(8, 'se', 'malmo', 'Malmo Centrum', 55.609055, 12.999933, 'Mahan H', '', '', '', systimestamp, 'mahan', systimestamp, 'mahan', 0);
