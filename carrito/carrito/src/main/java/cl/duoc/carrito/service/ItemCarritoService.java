package cl.duoc.carrito.service;

import cl.duoc.carrito.dto.ItemCarritoRequestDTO;
import cl.duoc.carrito.dto.ItemCarritoResponseDTO;
import cl.duoc.carrito.model.ItemCarrito;
import cl.duoc.carrito.repository.ItemCarritoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemCarritoService {

    private static final Logger log = LoggerFactory.getLogger(ItemCarritoService.class);
    private final ItemCarritoRepository repository;

    private ItemCarritoResponseDTO toResponse(ItemCarrito item) {
        return ItemCarritoResponseDTO.builder()
                .id(item.getId())
                .usuarioId(item.getUsuarioId())
                .productoId(item.getProductoId())
                .cantidad(item.getCantidad())
                .precioUnitario(item.getPrecioUnitario())
                .subtotal(item.getCantidad() * item.getPrecioUnitario())
                .fechaAgregado(item.getFechaAgregado())
                .build();
    }

    public ItemCarritoResponseDTO agregarItem(ItemCarritoRequestDTO dto) {
        log.info("Agregando producto ID: {} al carrito del usuario ID: {}", dto.getProductoId(), dto.getUsuarioId());
        if (repository.existsByUsuarioIdAndProductoId(dto.getUsuarioId(), dto.getProductoId())) {
            throw new RuntimeException("El producto ya está en el carrito de este usuario");
        }
        ItemCarrito item = ItemCarrito.builder()
                .usuarioId(dto.getUsuarioId())
                .productoId(dto.getProductoId())
                .cantidad(dto.getCantidad())
                .precioUnitario(dto.getPrecioUnitario())
                .build();
        ItemCarrito guardado = repository.saveAndFlush(item);
        log.info("Item agregado con ID: {}", guardado.getId());
        return toResponse(guardado);
    }

    public List<ItemCarritoResponseDTO> obtenerTodos() {
        log.info("Obteniendo todos los items del carrito");
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ItemCarritoResponseDTO> obtenerPorUsuario(long usuarioId) {
        log.info("Obteniendo carrito del usuario ID: {}", usuarioId);
        return repository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ItemCarritoResponseDTO obtenerPorId(long id) {
        log.info("Buscando item con ID: {}", id);
        ItemCarrito item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado con ID: " + id));
        return toResponse(item);
    }

    public ItemCarritoResponseDTO actualizarItem(long id, ItemCarritoRequestDTO dto) {
        log.info("Actualizando item ID: {}", id);
        ItemCarrito existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado con ID: " + id));
        existente.setCantidad(dto.getCantidad());
        existente.setPrecioUnitario(dto.getPrecioUnitario());
        return toResponse(repository.saveAndFlush(existente));
    }

    public void eliminarItem(long id) {
        log.info("Eliminando item con ID: {}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Item no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    public void vaciarCarrito(long usuarioId) {
        log.info("Vaciando carrito del usuario ID: {}", usuarioId);
        repository.deleteByUsuarioId(usuarioId);
    }
}