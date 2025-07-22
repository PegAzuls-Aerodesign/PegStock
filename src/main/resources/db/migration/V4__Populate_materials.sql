--- Script de população para a tabela tb_material (versão corrigida com enums reais) ---

INSERT INTO tb_material (name, brand, description, quantity, consumer_quantity, category, box, expiration_date, created_date, register_date, last_add_date, last_consumption_date) VALUES
-- Eletrônicos e Elétrica
('Resistor de Precisão 1K Ohm', 'Vishay', 'Resistor de filme metálico com 1% de tolerância.', 150, 25, 'CONSUMIVEL', 'ELETRICA', '2028-12-31', '2023-01-10', '2023-02-15', '2024-05-20', '2024-06-11'),
('Placa Arduino Nano', 'Arduino', 'Microcontrolador baseado no ATmega328.', 25, 5, 'PERMANENTE', 'ELETRICA', '2029-01-01', '2023-03-01', '2023-03-20', '2024-04-10', NULL),
('Servo Motor SG90', 'Tower Pro', 'Micro servo motor 9g para aeromodelismo.', 40, 12, 'CONSUMIVEL', 'ELETRICA', '2027-06-30', '2022-11-20', '2023-01-25', '2024-03-15', '2024-07-01'),
('Bateria LiPo 3S 2200mAh', 'Turnigy', 'Bateria de polímero de lítio 11.1V 3S.', 15, 4, 'CONSUMIVEL', 'ELETRICA', '2026-05-15', '2024-05-10', '2024-05-20', '2024-05-20', '2024-06-25'),
('Módulo GPS NEO-6M', 'U-blox', 'Módulo receptor GPS para projetos de localização.', 20, 2, 'PERMANENTE', 'ELETRICA', '2028-10-20', '2023-08-11', '2023-09-01', '2023-09-01', NULL),
('Sensor de Pressão BMP280', 'Bosch', 'Sensor de pressão barométrica e altitude.', 30, 8, 'PERMANENTE', 'ELETRICA', '2029-02-28', '2023-07-15', '2023-08-01', '2024-01-10', '2024-02-20'),
('Fio de Cobre Esmaltado 24AWG', 'Diversos', 'Rolo com 50m de fio de cobre para bobinas.', 10, 3, 'CONSUMIVEL', 'ELETRICA', '2030-01-01', '2022-10-01', '2023-02-10', '2023-02-10', '2023-11-15'),
('Display OLED 0.96"', 'Adafruit', 'Display de 128x64 pixels com interface I2C.', 22, 6, 'PERMANENTE', 'ELETRICA', '2028-08-31', '2023-09-01', '2023-09-15', '2024-06-01', '2024-07-02'),
('Protoboard 830 Furos', 'Diversos', 'Placa de ensaio para montagem de circuitos.', 50, 15, 'PERMANENTE', 'ELETRICA', '2030-12-31', '2022-01-01', '2023-01-15', '2023-01-15', '2024-05-10'),
('Capacitor Eletrolítico 100uF', 'Epcos', 'Capacitor 100uF x 25V.', 200, 75, 'CONSUMIVEL', 'ELETRICA', '2027-09-30', '2023-04-10', '2023-05-01', '2024-02-20', '2024-07-18'),

-- Estruturais e Outros
('Tubo de Fibra de Carbono 10mm', 'CarbonTech', 'Tubo de 1m de comprimento e 10mm de diâmetro.', 12, 3, 'CONSUMIVEL', 'ESTANTE', '2030-01-01', '2023-10-05', '2023-11-01', '2024-01-20', '2024-03-22'),
('Vareta de Balsa 5x5mm', 'Pau-Balsa', 'Vareta de madeira balsa com 1m de comprimento.', 100, 30, 'CONSUMIVEL', 'PALITOS', '2026-06-01', '2024-01-15', '2024-02-01', '2024-06-10', '2024-07-15'),
('Chapa de Alumínio 1mm', 'Alcoa', 'Chapa de 50x50cm de alumínio naval.', 8, 1, 'CONSUMIVEL', 'ESTANTE', '2035-01-01', '2023-06-20', '2023-07-10', '2023-07-10', NULL),
('Perfil de Alumínio "L" 2020', 'Diversos', 'Barra de 1m de perfil de alumínio 20x20mm.', 15, 4, 'CONSUMIVEL', 'ESTANTE', '2032-10-10', '2023-11-01', '2023-11-20', '2024-03-01', '2024-05-16'),
('Madeira de Compensado Naval 4mm', 'Leo Madeiras', 'Chapa de 1x1m de compensado naval.', 5, 2, 'CONSUMIVEL', 'ESTANTE', '2027-08-15', '2024-02-10', '2024-03-01', '2024-03-01', '2024-06-20'),
('Tubo de PVC 25mm', 'Tigre', 'Barra de 3m de tubo de PVC.', 10, 3, 'CONSUMIVEL', 'OUTROS', '2029-05-20', '2023-05-15', '2023-06-01', '2023-06-01', NULL),
('Cantoneira de Aço', 'Gerdau', 'Barra de 1m de cantoneira de aço perfurada.', 20, 5, 'CONSUMIVEL', 'ESTANTE', '2034-04-18', '2023-04-10', '2023-04-20', '2023-04-20', '2024-01-05'),
('Dobradiça de Nylon para Aeromodelo', 'HobbyKing', 'Pacote com 10 dobradiças.', 30, 8, 'CONSUMIVEL', 'OUTROS', '2028-11-25', '2023-11-15', '2023-12-01', '2024-02-01', '2024-04-12'),
('Rodas de Espuma 50mm', 'Dubro', 'Par de rodas de espuma para trem de pouso.', 25, 6, 'CONSUMIVEL', 'DESEMPENHO', '2027-10-30', '2024-04-20', '2024-05-05', '2024-05-05', '2024-07-19'),
('Montante de Motor de Plástico', 'GWS', 'Montante para motores classe 400.', 35, 9, 'CONSUMIVEL', 'DESEMPENHO', '2029-09-09', '2023-09-01', '2023-09-10', '2024-01-11', '2024-02-22'),

-- Fixadores
('Parafuso Allen M3x10mm', 'Ciser', 'Pacote com 50 parafusos de aço inox.', 10, 2, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2030-01-01', '2023-02-20', '2023-03-10', '2024-06-05', '2024-07-10'),
('Porca Autotravante M3', 'Ciser', 'Pacote com 50 porcas com trava de nylon.', 10, 3, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2030-01-01', '2023-02-20', '2023-03-10', '2024-06-05', '2024-07-10'),
('Abraçadeira de Nylon (Enforca Gato) 15cm', 'Diversos', 'Pacote com 100 abraçadeiras pretas.', 5, 2, 'CONSUMIVEL', 'FITAS', '2028-07-20', '2023-07-10', '2023-07-20', '2023-07-20', '2024-06-28'),
('Arruela Lisa M4', 'Metalmatrix', 'Pacote com 100 arruelas de aço.', 8, 1, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2035-01-01', '2023-05-01', '2023-05-15', '2023-05-15', NULL),
('Rebite de Repuxo 4mm', 'Diversos', 'Caixa com 50 rebites de alumínio.', 4, 1, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2032-04-15', '2023-04-01', '2023-04-15', '2023-04-15', '2023-12-01'),
('Fita Dupla Face de Espuma', '3M', 'Rolo de 5m de fita VHB.', 12, 5, 'CONSUMIVEL', 'FITAS', '2025-08-31', '2024-02-20', '2024-03-05', '2024-06-15', '2024-07-20'),
('Parafuso para Madeira 3.5x25mm', 'Philips', 'Caixa com 200 parafusos.', 3, 1, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2031-03-10', '2022-03-01', '2022-03-10', '2022-03-10', NULL),
(' velcro adesivo', 'Velcro', 'Rolo de 1m de velcro com adesivo.', 15, 6, 'CONSUMIVEL', 'FITAS', '2026-11-30', '2023-11-20', '2023-12-05', '2024-03-20', '2024-06-22'),
('Ima de Neodímio 10x2mm', 'Diversos', 'Pacote com 20 ímãs de terras raras.', 9, 4, 'CONSUMIVEL', 'OUTROS', '2035-01-01', '2024-01-10', '2024-01-25', '2024-01-25', '2024-05-30'),
('Ganchos tipo "S"', 'Diversos', 'Pacote com 20 ganchos de aço.', 6, 2, 'PERMANENTE', 'FERRAMENTAS', '2033-07-14', '2023-07-01', '2023-07-14', '2023-07-14', NULL),

-- Químicos e Colas
('Resina Epóxi Kit 1kg', 'Redecor', 'Kit com resina e endurecedor de baixa viscosidade.', 7, 2, 'CONSUMIVEL', 'COLA', '2025-02-15', '2024-02-20', '2024-03-01', '2024-05-10', '2024-07-05'),
('Manta de Fibra de Vidro 300g/m²', 'Owens Corning', 'Rolo com 1m² de manta de fibra de vidro.', 10, 3, 'CONSUMIVEL', 'OUTROS', '2027-01-20', '2023-01-10', '2023-01-20', '2023-01-20', '2024-04-18'),
('Cola Cianoacrilato (Super Bonder)', 'Loctite', 'Frasco de 20g de cola de secagem rápida.', 25, 9, 'CONSUMIVEL', 'COLA', '2024-12-01', '2023-12-10', '2024-01-05', '2024-05-15', '2024-07-16'),
('Tinta Spray Preto Fosco', 'Colorgin', 'Lata de 400ml de tinta acrílica.', 18, 5, 'CONSUMIVEL', 'OUTROS', '2025-09-30', '2024-03-25', '2024-04-10', '2024-04-10', '2024-07-01'),
('Álcool Isopropílico 1L', 'Diversos', 'Álcool para limpeza de componentes eletrônicos.', 6, 2, 'CONSUMIVEL', 'LIMPEZA', '2026-04-22', '2024-04-15', '2024-04-22', '2024-04-22', '2024-06-29'),
('Massa de Calafetar', '3M', 'Tubo de 280g para vedação.', 4, 1, 'CONSUMIVEL', 'COLA', '2024-10-10', '2023-10-01', '2023-10-10', '2023-10-10', NULL),
('WD-40 Lubrificante Multiuso', 'WD-40', 'Lata de 300ml.', 9, 3, 'CONSUMIVEL', 'LIMPEZA', '2028-05-25', '2023-05-15', '2023-05-25', '2023-05-25', '2024-07-12'),
('Tecido de Fibra de Carbono 200g/m²', 'CarbonTech', 'Rolo de 1m² de tecido twill 3k.', 5, 1, 'CONSUMIVEL', 'DESEMPENHO', '2030-03-14', '2024-03-01', '2024-03-14', '2024-03-14', '2024-06-14'),
('Adesivo de Silicone', 'Sikaflex', 'Tubo de 300ml de selante de silicone.', 8, 2, 'CONSUMIVEL', 'COLA', '2025-01-20', '2024-01-10', '2024-01-20', '2024-01-20', NULL),
('Ativador para Cianoacrilato', 'Tekbond', 'Spray de 200ml para acelerar a cura.', 7, 2, 'CONSUMIVEL', 'COLA', '2025-06-18', '2024-06-08', '2024-06-18', '2024-06-18', '2024-07-16'),
('Cola Quente (Bastão Grosso)', 'Diversos', 'Pacote com 10 bastões de cola.', 20, 8, 'CONSUMIVEL', 'BASTAO_COLA_QUENTE', '2026-09-19', '2024-03-10', '2024-03-19', '2024-03-19', '2024-07-09'),
('Estanho para Solda 1mm', 'Best', 'Rolo de 250g de estanho 60/40.', 6, 2, 'CONSUMIVEL', 'ELETRICA', '2029-08-10', '2023-08-01', '2023-08-10', '2024-06-20', '2024-07-17'),
('Fita Isolante 20m', '3M', 'Rolo de fita isolante preta.', 20, 7, 'CONSUMIVEL', 'FITAS', '2027-05-19', '2023-05-10', '2023-05-19', '2024-04-01', '2024-06-30'),

-- Ferramentas
('Alicate de Corte de Precisão', 'Tramontina', 'Alicate para eletrônica.', 5, 0, 'PERMANENTE', 'FERRAMENTAS', '2040-01-01', '2022-05-10', '2022-05-10', '2022-05-10', NULL),
('Chave de Fenda Phillips PH1', 'Gedore', 'Chave com ponta magnetizada.', 8, 0, 'PERMANENTE', 'FERRAMENTAS', '2040-01-01', '2022-05-10', '2022-05-10', '2022-05-10', NULL),
('Estação de Solda 60W', 'Yaxun', 'Estação com controle de temperatura.', 3, 0, 'PERMANENTE', 'FERRAMENTAS_ELETRICAS', '2035-01-01', '2022-08-15', '2022-08-15', '2022-08-15', NULL),
('Multímetro Digital', 'Minipa', 'Multímetro com medição de True RMS.', 4, 0, 'PERMANENTE', 'FERRAMENTAS_ELETRICAS', '2038-01-01', '2023-01-20', '2023-01-20', '2023-01-20', '2024-02-15'),
('Paquímetro Digital 150mm', 'Zaas', 'Paquímetro de aço inox.', 3, 0, 'PERMANENTE', 'FERRAMENTAS', '2037-01-01', '2022-11-30', '2022-11-30', '2022-11-30', NULL),
('Soprador Térmico 1500W', 'Black+Decker', 'Soprador com 2 níveis de temperatura.', 2, 0, 'PERMANENTE', 'FERRAMENTAS_ELETRICAS', '2036-01-01', '2023-04-18', '2023-04-18', '2023-04-18', '2024-05-22'),
('Furadeira de Bancada', 'Schulz', 'Furadeira para trabalhos de precisão.', 1, 0, 'PERMANENTE', 'FERRAMENTAS_ELETRICAS', '2045-01-01', '2022-09-10', '2022-09-10', '2022-09-10', NULL),
('Jogo de Chaves Allen', 'King Tony', 'Jogo com 9 chaves de 1.5mm a 10mm.', 5, 0, 'PERMANENTE', 'FERRAMENTAS', '2042-01-01', '2023-02-01', '2023-02-01', '2023-02-01', NULL),
('Lixa d''água (Kit)', '3M', 'Kit com folhas de grão 220 a 2000.', 15, 5, 'CONSUMIVEL', 'LIXAS', '2030-06-25', '2023-06-15', '2023-06-25', '2023-06-25', '2024-06-26'),
('Alicate de Bico', 'Belzer', 'Alicate de bico meia cana.', 6, 0, 'PERMANENTE', 'FERRAMENTAS', '2040-01-01', '2022-05-10', '2022-05-10', '2022-05-10', NULL),
('Pistola de Cola Quente', 'Tramontina', 'Pistola pequena bivolt.', 3, 0, 'PERMANENTE', 'FERRAMENTAS_ELETRICAS', '2040-08-10', '2022-08-01', '2022-08-10', '2022-08-10', NULL),
('Arco de Serra Pequeno', 'Starrett', 'Mini arco de serra.', 4, 0, 'PERMANENTE', 'FERRAMENTAS_CORTANTES', '2041-02-15', '2022-08-05', '2022-08-15', '2022-08-15', NULL),
('Sargento tipo "C" 3 polegadas', 'Irwin', 'Sargento para fixação.', 10, 0, 'PERMANENTE', 'FERRAMENTAS', '2043-05-20', '2023-05-10', '2023-05-20', '2023-05-20', NULL),
('Óculos de Proteção', '3M', 'Óculos de segurança com lentes anti-risco.', 12, 0, 'PERMANENTE', 'EPI_TI', '2028-09-10', '2023-09-01', '2023-09-10', '2023-09-10', '2024-02-28'),
('Luvas de Malha Pigmentada', 'Diversos', 'Par de luvas de proteção.', 20, 0, 'PERMANENTE', 'EPI_TI', '2027-11-05', '2023-10-25', '2023-11-05', '2023-11-05', NULL),

-- Materiais Vencidos para Teste
('Cola Epóxi 5 Minutos', 'Araldite', 'Seringa com 10g.', 10, 8, 'CONSUMIVEL', 'COLA', '2024-05-01', '2023-05-01', '2023-05-15', '2023-11-10', '2024-01-20'),
('Bateria LiPo 2S 800mAh', 'Zippy', 'Bateria de polímero de lítio 7.4V 2S.', 5, 5, 'SEM_USO', 'DESEMPENHO', '2023-12-31', '2022-12-01', '2023-01-10', '2023-01-10', '2023-09-05'),
('Tinta Spray Prata', 'Suvinil', 'Lata de 400ml de tinta.', 3, 3, 'SEM_USO', 'OUTROS', '2024-01-15', '2023-01-10', '2023-01-15', '2023-01-15', '2023-10-25'),
('Resina de Poliéster Kit 500g', 'Maxi Rubber', 'Kit com resina e catalisador.', 2, 2, 'SEM_USO', 'COLA', '2024-03-20', '2023-03-15', '2023-03-20', '2023-03-20', '2023-11-28'),
('Fita Crepe 18mm', 'Adere', 'Rolo de 50m de fita crepe.', 1, 1, 'SEM_USO', 'FITAS', '2024-06-30', '2022-06-20', '2022-07-01', '2022-07-01', '2023-02-10'),

-- Mais Eletrônicos
('Módulo Bluetooth HC-05', 'Diversos', 'Módulo serial para comunicação sem fio.', 18, 4, 'PERMANENTE', 'ELETRICA', '2029-07-22', '2023-07-15', '2023-07-22', '2024-02-18', '2024-05-19'),
('Regulador de Tensão 7805', 'STMicroelectronics', 'Regulador de 5V positivo.', 50, 20, 'CONSUMIVEL', 'ELETRICA', '2030-04-10', '2023-04-01', '2023-04-10', '2023-04-10', '2024-06-15'),
('Raspberry Pi Pico', 'Raspberry Pi', 'Microcontrolador RP2040.', 15, 3, 'PERMANENTE', 'ELETRICA', '2031-01-15', '2024-01-05', '2024-01-15', '2024-01-15', '2024-07-11'),
('Câmera para Raspberry Pi', 'Raspberry Pi', 'Módulo de câmera de 8MP.', 10, 1, 'PERMANENTE', 'ELETRICA', '2030-09-20', '2023-09-10', '2023-09-20', '2023-09-20', NULL),
('Jumpers Macho-Macho', 'Diversos', 'Conjunto com 40 jumpers coloridos.', 30, 10, 'CONSUMIVEL', 'ELETRICA', '2032-05-30', '2023-05-20', '2023-05-30', '2024-01-20', '2024-07-08'),

-- Mais Estruturais e Desempenho
('Chapa de Policarbonato 2mm', 'Lexan', 'Chapa transparente de 30x30cm.', 9, 2, 'CONSUMIVEL', 'ESTANTE', '2033-08-25', '2023-08-15', '2023-08-25', '2024-04-25', '2024-06-25'),
('Link de Nylon para Servo', 'Dubro', 'Pacote com 10 links e parafusos.', 40, 15, 'CONSUMIVEL', 'DESEMPENHO', '2029-10-10', '2023-10-01', '2023-10-10', '2024-02-29', '2024-05-29'),
('Hélice 10x4.7 Slow Fly', 'APC', 'Hélice para aeromodelos elétricos.', 50, 22, 'CONSUMIVEL', 'DESEMPENHO', '2028-02-20', '2024-02-10', '2024-02-20', '2024-06-12', '2024-07-19'),
('Spinner de Plástico 50mm', 'Diversos', 'Spinner (cone de hélice) branco.', 20, 5, 'CONSUMIVEL', 'DESEMPENHO', '2030-07-15', '2023-07-05', '2023-07-15', '2023-07-15', NULL),
('Tubo Termo Retrátil (Kit)', 'Diversos', 'Caixa com tubos de diversos diâmetros.', 12, 4, 'CONSUMIVEL', 'FITAS', '2029-06-10', '2023-06-01', '2023-06-10', '2024-05-11', '2024-07-07'),

-- Mais Fixadores
('Parafuso Allen M2.5x8mm', 'Ciser', 'Pacote com 50 parafusos de aço.', 15, 3, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2031-05-20', '2023-05-10', '2023-05-20', '2024-03-25', '2024-06-19'),
('Porca borboleta M4', 'Metalmatrix', 'Pacote com 20 porcas.', 8, 2, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2034-09-15', '2023-09-05', '2023-09-15', '2023-09-15', '2024-04-24'),
('Fita de Cobre Adesiva', 'Diversos', 'Rolo de 10m para blindagem EMI.', 7, 1, 'CONSUMIVEL', 'FITAS', '2028-10-05', '2023-09-25', '2023-10-05', '2023-10-05', NULL),
('Anel de Retenção (Trava Elástica) 10mm', 'Diversos', 'Pacote com 50 anéis.', 5, 2, 'CONSUMIVEL', 'PARAFUSO_DERIVADOS', '2033-11-11', '2022-11-01', '2022-11-11', '2022-11-11', '2023-10-13');