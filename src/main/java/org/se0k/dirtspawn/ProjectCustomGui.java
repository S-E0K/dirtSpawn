package org.se0k.dirtspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings({"deprecation", "unused"})
public class ProjectCustomGui implements InventoryHolder {
    private final Inventory inventory;
    private final Map<Integer, Button> buttonMap = new HashMap<>();

    public ProjectCustomGui(String title, int slot) {
        this.inventory = Bukkit.createInventory(this, slot, title);
    }

    public ProjectCustomGui(int slot) {
        this.inventory = Bukkit.createInventory(this, slot);
    }

    public ProjectCustomGui(String title, InventoryType type) {
        this.inventory = Bukkit.createInventory(this, type, title);
    }

    public ProjectCustomGui(InventoryType type) {
        this.inventory = Bukkit.createInventory(this, type);
    }

    public Button getButton(int slot) {
        return this.buttonMap.get(slot);
    }

    public boolean hasButton(int slot) {
        return this.buttonMap.containsKey(slot);
    }

    public void setButton(int slot, Button button) {
        this.buttonMap.put(slot, button);
    }

    public void removeButton(int slot) {
        this.buttonMap.remove(slot);
    }

    public int getSize() {
        return inventory.getSize();
    }

    public int getMaxStackSize() {
        return inventory.getMaxStackSize();
    }

    public void setMaxStackSize(int i) {
        inventory.setMaxStackSize(i);
    }

    public ItemStack getItem(int i) {
        return inventory.getItem(i);
    }

    public ItemStack setItem(int i, ItemStack itemStack) {
        inventory.setItem(i, itemStack);
        return this.getItem(i);
    }

    public ItemStack setItem(int i, ItemStack itemStack, Button button) {
        inventory.setItem(i, itemStack);
        this.setButton(i, button);
        return this.getItem(i);
    }

    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return inventory.addItem(itemStacks);
    }

    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return inventory.removeItem(itemStacks);
    }

    public ItemStack[] getContents() {
        return inventory.getContents();
    }

    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        inventory.setContents(itemStacks);
    }

    public ItemStack[] getStorageContents() {
        return inventory.getStorageContents();
    }

    public void setStorageContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        inventory.setStorageContents(itemStacks);
    }

    public boolean contains(Material material) throws IllegalArgumentException {
        return inventory.contains(material);
    }

    public boolean contains(ItemStack itemStack) {
        return inventory.contains(itemStack);
    }

    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return inventory.contains(material, i);
    }

    public boolean contains(ItemStack itemStack, int i) {
        return inventory.contains(itemStack, i);
    }

    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return inventory.containsAtLeast(itemStack, i);
    }

    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return inventory.all(material);
    }

    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return inventory.all(itemStack);
    }

    public int first(Material material) throws IllegalArgumentException {
        return inventory.first(material);
    }

    public int first(ItemStack itemStack) {
        return inventory.first(itemStack);
    }

    public int firstEmpty() {
        return inventory.firstEmpty();
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public void remove(Material material) throws IllegalArgumentException {
        inventory.remove(material);
    }

    public void remove(ItemStack itemStack) {
        inventory.remove(itemStack);
    }

    public void clear(int i) {
        inventory.clear(i);
    }

    public void clear() {
        inventory.clear();
    }

    public List<HumanEntity> getViewers() {
        return inventory.getViewers();
    }

    public InventoryType getType() {
        return inventory.getType();
    }

    public InventoryHolder getHolder() {
        return inventory.getHolder();
    }

    public ListIterator<ItemStack> iterator() {
        return inventory.iterator();
    }

    public ListIterator<ItemStack> iterator(int i) {
        return inventory.iterator(i);
    }

    public Location getLocation() {
        return inventory.getLocation();
    }

    public void forEach(Consumer<? super ItemStack> action) {
        inventory.forEach(action);
    }

    public Spliterator<ItemStack> spliterator() {
        return inventory.spliterator();
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }

    public interface Button {// 원래 버튼은 다른 클래스에 있었는데 내가 여기 옮겼어
        void onClick(InventoryClickEvent event);
    } // 이거로 이벤트 받아오는거야 이건 맨 밑에 적어놔야해 ㅇㅇ
}
