package crm.preset.registry;


import crm.preset.model.AccountContext;
import crm.preset.model.AccountPreset;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PresetRegistry {

	private final ConcurrentHashMap<Long, AccountPreset> presets = new ConcurrentHashMap<>();

	private volatile AccountContext rootContext;

	public void register(AccountPreset preset) {
		Objects.requireNonNull(preset,"preset не должно быть null");
		validateId(preset.id());
		presets.put(preset.id(),preset);
	}

	public AccountPreset getPreset(long presetId) {
		validateId(presetId);

		return presets.get(presetId);
	}

	public void remove(long presetId) {
		validateId(presetId);
		presets.remove(presetId);
	}

	public Set<Long> getAllPresetIds( ) {
		return Set.copyOf(presets.keySet());
	}

	public void setRootContext(AccountContext rootContext) {
		Objects.requireNonNull(rootContext,"rootContext не должен быть равен null");
		this.rootContext = rootContext;
	}

	public AccountContext getRootContext( ) {
		AccountContext ctx = rootContext;
		if (ctx == null) throw new IllegalStateException("rootContext не инициализирован");
		return ctx;
	}

	private void validateId(long id) {
		if (id <= 0) {
			throw new IllegalArgumentException("id должен быть больше 0, получено: " + id);
		}

	}

}