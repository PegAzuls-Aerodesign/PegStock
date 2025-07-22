CREATE TABLE tb_material_status (
    material_id BIGINT NOT NULL,
    status VARCHAR(50),
    CONSTRAINT fk_material FOREIGN KEY (material_id) REFERENCES tb_material (cod) ON DELETE CASCADE
);