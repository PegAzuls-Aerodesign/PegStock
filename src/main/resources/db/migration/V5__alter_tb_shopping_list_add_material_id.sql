ALTER TABLE tb_shopping_list ADD COLUMN material_cod BIGINT;
ALTER TABLE tb_shopping_list
ADD CONSTRAINT fk_shopping_list_material
FOREIGN KEY (material_cod) REFERENCES tb_material(cod);